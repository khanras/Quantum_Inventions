package testCases;

import org.testng.annotations.Test;
import actions.LoginPage;

public class TC03 extends SuitClass {
	
	@Test
	public void checkMobileAppNavigation() throws Exception {
		new LoginPage().login(testExector);
	}
}