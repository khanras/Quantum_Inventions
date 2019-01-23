package actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utility.TestExecutor;

public class MobileAppPage {
	private static final Logger logger = LoggerFactory.getLogger(MobileAppPage.class);
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
					.waitToBeClickableBy("MobileApp")
					.takeScreenshot("ScreenshotPath","MobileApp_Home");
	}

	
}
