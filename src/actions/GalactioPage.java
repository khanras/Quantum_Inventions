package actions;

import utility.TestExecutor;

public class GalactioPage {
	public void galactioPageNavigation(TestExecutor testExecutor) {
		testExecutor.waitToBeClickableBy("Galactio")
					.clickBy("Galactio")
					.switchToTab(1)
					.verifyTitle("galactio")
					.closeTabByIndex(1);
					
	}

	
}
