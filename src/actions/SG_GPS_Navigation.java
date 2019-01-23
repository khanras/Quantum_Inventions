package actions;

import utility.TestExecutor;

public class SG_GPS_Navigation {
	public void SgGPSNavigatio(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("SGGPSNavigation")
					.clickBy("SGGPSNavigation")
					.switchToTab(1)
					.verifyTitle("SG_GPS_Navigation")
					.closeTabByIndex(1);
					
	}

	
}
