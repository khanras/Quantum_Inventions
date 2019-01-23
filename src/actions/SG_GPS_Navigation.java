package actions;

import utility.TestExecutor;

public class SG_GPS_Navigation {
	public void SgGPSNavigatio(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("SGGPSNavigation")
					.clickBy("SGGPSNavigation")
					.switchToTab(1)
					.waitVisibilityOfElementBy("GalactioAppInstallButton")
					.takeScreenshot("ScreenshotPath","SG_GPS_Navigation");
		testExecutor.verifyTitle("SG_GPS_Navigation")
					.closeTabByIndex(1)
					.waitVisibilityOfElementBy("SGGPSNavigation")
					.takeScreenshot("ScreenshotPath","SG_GPS_Navigation_Home_page");
					
	}

	
}
