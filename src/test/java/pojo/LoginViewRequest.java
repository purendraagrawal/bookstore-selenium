package pojo;

public class LoginViewRequest {
	private String userName;
	private String password;

	public LoginViewRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

}
