package actions;

import utility.TestExecutor;

public class MobileAppPage {
	public void mobileAppNavigation(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("MobileApp")
					.clickBy("MobileApp")
					.switchToTab(1)
					.verifyTitle("mobileApp")
					.closeTabByIndex(1);
					
	}

	
}
