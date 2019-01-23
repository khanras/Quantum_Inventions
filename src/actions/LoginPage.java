package actions;

import org.testng.Assert;

import utility.TestExecutor;

public class LoginPage {
	public void login(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("SignIn")
					.verifyTitle("home")
		 			.clickBy("SignIn")
		 			.waitToBeClickableBy("UserName")
					.verifyTitle("signIn");
		
		testExecutor.sendKeysBy("UserName")
					.sendKeysBy("Password")
					.clickBy("LoginButton");
		String actualText =testExecutor.getTextBy("LoginError");
		Assert.assertEquals(actualText, "Invalid user/password combination1");
		System.out.println("Invalid user/password combination as expected.");
				
	}

	
}
