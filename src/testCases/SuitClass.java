package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utility.TestExecutor;
import utility.data.StaticData;

public class SuitClass {

	public TestExecutor testExector = null;

	@BeforeClass
	public void init() throws Exception {
		StaticData.xlspath=StaticData.readProperty("xlsPath");
		testExector = new TestExecutor(StaticData.xlspath);
	}
	
	@AfterClass
	public void tearDown() {
		testExector.getWebDriver().quit();
	}
	
	@AfterSuite
	public void renameLog() {
		File file = new File("D:\\git\\Quantum_Inventions\\log\\TestNG.log");
		String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		if(file.renameTo(new File("D:\\git\\Quantum_Inventions\\log\\TestNG_"+timestamp+".log"))) {
			System.out.println("rename done.");
		}
			
	}
}