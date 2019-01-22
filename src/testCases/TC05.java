package testCases;

import org.testng.annotations.Test;
import actions.LoginPage;

public class TC05 extends SuitClass {
	
	@Test
	public void checkSGGPSNavigation() throws Exception {
		new LoginPage().login(testExector);
	}
}