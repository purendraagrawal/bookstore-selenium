package stepdefinition;

import apiEngine.IRestResponseContext;
import apiEngine.RestRequestContext;
import apiEngine.RestResponseContext;
import pojo.GenerateTokenResponse;
import pojo.LoginViewRequest;

public class BaseAPIStepDef extends BaseStepDef {

	protected final String userId;

	public BaseAPIStepDef() {
		userId = config.getValueOfKey("userId");
	}

	protected String generateToken(String username, String password) {
		RestRequestContext request = new RestRequestContext();
		request.setContentTypeJSON();
		LoginViewRequest loginRequest = new LoginViewRequest(username, password);
		request.setRequestBody(loginRequest);
		IRestResponseContext<GenerateTokenResponse> generateToken = new RestResponseContext<>(
				GenerateTokenResponse.class, request.getResponse("POST", "/Account/v1/GenerateToken"));
		String token = generateToken.getBody().getToken();
		return token;
	}
}
