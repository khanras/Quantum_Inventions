package testCases;

import org.testng.annotations.Test;
import actions.LoginPage;

public class TC04 extends SuitClass {
	
	@Test
	public void checkGalactioNavigation() throws Exception {
		new LoginPage().login(testExector);
	}
}