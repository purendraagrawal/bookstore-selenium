package apiEngine;

import io.restassured.response.Response;

public interface IRestResponseContext<T> {

	public T getBody();

	public String getContent();

	public int getStatusCode();

	public boolean isSuccessfull(int expectedResponseCode);

	public String getStatusDescription();

	public Response getResponse();

	public Exception getException();
}
