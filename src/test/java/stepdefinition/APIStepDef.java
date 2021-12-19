package stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import apiEngine.IRestResponseContext;
import apiEngine.RestRequestContext;
import apiEngine.RestResponseContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.AddListOfBooksRequest;
import pojo.DeleteBookRequest;
import pojo.ISBN;

public class APIStepDef extends BaseAPIStepDef {

	@Then("Delete the Book ISBN {string} using API")
	public void deleteABook(String isbnName) {
		request = new RestRequestContext();
		request.setContentTypeJSON();
		DeleteBookRequest deleteBookRequestBody = new DeleteBookRequest(isbnName, userId);
		request.setBearerToken(generateToken(userName, password));
		request.setRequestBody(deleteBookRequestBody);
		Response response = request.getResponse("DELETE", "/BookStore/v1/Book");
		Assert.assertEquals(204, response.getStatusCode());
	}

	@When("a Book ISBN {string} is added using API")
	public void addABook(String isbnName) {
		request = new RestRequestContext();
		request.setContentTypeJSON();
		ISBN firstBook = new ISBN(isbnName);
		List<ISBN> collectionOfBookList = new ArrayList<>();
		collectionOfBookList.add(firstBook);
		AddListOfBooksRequest addListOfBookRequestBody = new AddListOfBooksRequest(userId, collectionOfBookList);
		request.setBearerToken(generateToken(userName, password));
		request.setRequestBody(addListOfBookRequestBody);
		IRestResponseContext<ISBN> addBookResponse = new RestResponseContext<>(ISBN.class,
				request.getResponse("POST", "/BookStore/v1/Books"));
		Assert.assertEquals(201, addBookResponse.getStatusCode());
		// Assert.assertEquals(isbnName, addBookResponse.getBody().getIsbn());
	}
}
