package actions;

import utility.TestExecutor;

public class GalactioPage {
	public void galactioPageNavigation(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("Galactio")
					.clickBy("Galactio")
					.switchToTab(1)
					.waitVisibilityOfElementBy("GalactioLogin")
					.verifyTitle("galactio")
					.takeScreenshot("ScreenshotPath","Galactio");
		testExecutor.closeTabByIndex(1)
					.waitToBeClickableBy("Galactio")
					.takeScreenshot("ScreenshotPath","Galactio_Home");
	}

	
}
