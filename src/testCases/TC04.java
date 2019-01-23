package testCases;

import org.testng.annotations.Test;

import actions.GalactioPage;

public class TC04 extends SuitClass {
	
	@Test
	public void checkGalactioNavigation() throws Exception {
		new GalactioPage().galactioPageNavigation(super.testExector);
	}
}