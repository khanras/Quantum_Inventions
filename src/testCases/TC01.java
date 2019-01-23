package testCases;

import org.testng.annotations.Test;
import actions.LoginPage;

public class TC01 extends SuitClass{
	
	@Test
	public void invalidLogin() throws Exception {
		
		new LoginPage().login(super.testExector);
	}
	
}