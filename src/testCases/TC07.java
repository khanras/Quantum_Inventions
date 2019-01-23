package testCases;

import org.testng.annotations.Test;

import actions.Calendar;

public class TC07 extends SuitClass {
	
	@Test
	public void checkLegend() throws Exception {
		new Calendar().screenshotOfCalendar(super.testExector);
	}
}