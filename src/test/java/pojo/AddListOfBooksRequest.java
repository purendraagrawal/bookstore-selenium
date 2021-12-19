package pojo;

import java.util.List;

public class AddListOfBooksRequest {
	private String userId;
	private List<ISBN> collectionOfIsbns;

	public AddListOfBooksRequest(String userId, List<ISBN> collectionOfIsbns) {
		this.userId = userId;
		this.collectionOfIsbns = collectionOfIsbns;
	}

	public List<ISBN> getCollectionOfIsbns() {
		return collectionOfIsbns;
	}

	public String getUserId() {
		return userId;
	}
}
