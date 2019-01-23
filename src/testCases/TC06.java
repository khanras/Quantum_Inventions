package testCases;

import org.testng.annotations.Test;

import actions.Legend;

public class TC06 extends SuitClass {
	
	@Test
	public void checkLegend() throws Exception {
		new Legend().screenshotOfLegend(super.testExector);
	}
}