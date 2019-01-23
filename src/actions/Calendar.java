package actions;

import utility.TestExecutor;

public class Calendar {
	public void screenshotOfCalendar(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("Calendar")
					.clickBy("Calendar")
					.takeScreenshot("ScreenshotPath","Calendar");
	}

	
}
