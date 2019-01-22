package testCases;

import org.testng.annotations.Test;
import actions.LoginPage;

public class TC06 extends SuitClass {
	
	@Test
	public void invalidRegister() throws Exception {
		new LoginPage().login(testExector);
	}
}