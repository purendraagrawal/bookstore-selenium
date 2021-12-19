package apiEngine;

import org.openqa.selenium.InvalidArgumentException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class RestRequestContext {

	RequestSpecification httpRequest;

	public RestRequestContext() {
		RestAssured.baseURI = ConfigReader.getInstance().getValueOfKey("baseURI");
		httpRequest = RestAssured.given();
	}

	public void setContentTypeJSON() {
		httpRequest.contentType(ContentType.JSON);
	}

	public void setBasicAuth(String username, String password) {
		httpRequest.auth().preemptive().basic(username, password);
	}

	public void setBearerToken(String token) {
		httpRequest.headers("Authorization", "Bearer " + token);
	}

	public void setRequestBody(Object object) {
		httpRequest.body(object);
	}

	public void setQueryParam(String key, String value) {
		httpRequest.queryParam(key, value);
	}

	public Response getResponse(String methodType, String endPoint) {
		switch (methodType.toUpperCase()) {
		case "GET":
			return httpRequest.get(endPoint);
		case "POST":
			return httpRequest.post(endPoint);
		case "PUT":
			return httpRequest.put(endPoint);
		case "DELETE":
			return httpRequest.delete(endPoint);
		default:
			break;
		}
		throw new InvalidArgumentException(methodType + " does not support.");
	}

}
