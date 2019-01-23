package testCases;

import org.testng.annotations.Test;
import actions.RegisterPage;

public class TC02 extends SuitClass{
	
	@Test
	public void invalidRegister() throws Exception {
		new RegisterPage().register(super.testExector);
	}
}