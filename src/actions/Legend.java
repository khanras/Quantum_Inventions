package actions;

import utility.TestExecutor;

public class Legend {
	public void screenshotOfLegend(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("Legend")
		.clickBy("Legend")
		.takeScreenshot("ScreenshotPath","Legend");
	}

	
}
