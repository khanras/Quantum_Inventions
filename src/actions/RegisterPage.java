package actions;

import utility.TestExecutor;

public class RegisterPage {
	public void register(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("Register")
					.verifyTitle("home")
		 			.clickBy("Register")
		 			.waitVisibilityOfElementBy("CreateProfile")
					.verifyTitle("register");
				
	}

	
}
