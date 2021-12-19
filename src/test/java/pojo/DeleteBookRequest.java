package pojo;

public class DeleteBookRequest {
	private String isbn;
	private String userId;

	public DeleteBookRequest(String isbn, String userId) {
		this.isbn = isbn;
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getIsbn() {
		return isbn;
	}
}
