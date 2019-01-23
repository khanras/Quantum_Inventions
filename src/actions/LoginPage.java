package actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import utility.TestExecutor;

public class LoginPage {
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
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
		testExecutor.takeScreenshot("ScreenshotPath","LoginError");
		Assert.assertEquals(actualText, "Invalid user/password combination");
		logger.info("Invalid user/password combination. It is as expected.");
				
	}

	
}
