package testCases;

import org.testng.annotations.Test;
import actions.MobileAppPage;

public class TC03 extends SuitClass {
	
	@Test
	public void checkMobileAppNavigation() throws Exception {
		new MobileAppPage().mobileAppNavigation(super.testExector);
	}
}