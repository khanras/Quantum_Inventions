package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import actions.LoginPage;
import utility.TestExecutor;
import utility.data.StaticData;

public class TC01{
	private TestExecutor testExecutor = null;

	@BeforeMethod
	public void init() throws Exception {
		StaticData.xlspath=StaticData.readProperty("xlsPath");
		testExecutor = new TestExecutor(StaticData.xlspath);
	}
	
	@AfterMethod
	public void tearDown() {
		testExecutor.getWebDriver().close();
	}
	@Test
	public void invalidLogin() throws Exception {
		new LoginPage().login(testExecutor);
	}
	
}