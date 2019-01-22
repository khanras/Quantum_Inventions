package testCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utility.TestExecutor;
import utility.data.StaticData;

public class SuitClass {

	public TestExecutor testExector = null;

	@BeforeTest
	public void init() throws Exception {
		StaticData.xlspath=StaticData.readProperty("xlsPath");
		testExector = new TestExecutor(StaticData.xlspath);
	}
	
	@AfterTest
	public void tearDown() {
		//testExector.getWebDriver().close();
	}
}