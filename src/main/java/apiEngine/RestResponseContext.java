package apiEngine;

import io.restassured.response.Response;

public class RestResponseContext<T> implements IRestResponseContext<T> {

	private T data;
	private Response response;
	private Exception e;

	public RestResponseContext(Class<T> t, Response response) {
		try {
			this.data = t.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("There should be default constructor in the Response POJO");
		}
		this.response = response;
	}

	@Override
	public T getBody() {
		try {
			data = (T) response.getBody().as(data.getClass());
		} catch (Exception e) {
			this.e = e;
		}
		return data;
	}

	@Override
	public String getContent() {
		return response.getBody().asString();
	}

	@Override
	public int getStatusCode() {
		return response.getStatusCode();
	}

	@Override
	public boolean isSuccessfull(int expectedResponseCode) {
		return (getStatusCode() == expectedResponseCode);
	}

	@Override
	public String getStatusDescription() {
		return response.getStatusLine();
	}

	@Override
	public Response getResponse() {
		return response;
	}

	@Override
	public Exception getException() {
		return e;
	}

}
