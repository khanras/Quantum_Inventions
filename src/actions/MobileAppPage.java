package actions;

import utility.TestExecutor;

public class MobileAppPage {
	public void mobileAppNavigation(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("MobileApp")
					.clickBy("MobileApp")
					.switchToTab(1)
					.waitVisibilityOfElementBy("MobileApp2")
					.clickBy("MobileApp2")
					.waitVisibilityOfElementBy("MobileApp2")
					.verifyTitle("mobileApp")
					.takeScreenshot("ScreenshotPath","MobileApp");
		testExecutor.closeTabByIndex(1)
					.waitVisibilityOfElementBy("MobileApp")
					.takeScreenshot("ScreenshotPath","MobileApp_Home");
	}

	
}
