package testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utility.TestExecutor;
import utility.data.StaticData;

public class SuitClass {
	private static final Logger logger = LoggerFactory.getLogger(SuitClass.class);
	public TestExecutor testExector = null;

	@BeforeClass
	public void init() throws Exception {
		logger.info("-------TESTCASE IS STARTED-------");
		StaticData.xlspath=StaticData.readProperty("xlsPath");
		testExector = new TestExecutor(StaticData.xlspath);
	}
	
	@AfterClass
	public void tearDown() {
		testExector.getWebDriver().quit();
		logger.info("--------TESTCASE IS ENDED--------");
	}
	
	@AfterSuite
	public void startLog() {
		logger.info("************************SUITE RUN HAS BEEN COMPLETED************************\n");
			
	}
	@BeforeSuite
	public void endLog() {
		logger.info("*************************SUITE RUN HAS BEEN STARTED*************************");
			
	}
}