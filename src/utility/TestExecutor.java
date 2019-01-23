package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import utility.data.StaticData;
import utility.data.TestData;

public class TestExecutor {

	private static final Logger logger = LoggerFactory.getLogger(TestExecutor.class);

	// private String outputDir = "D:/Tests/snaps/";

	private WebDriver dv;

	private WebDriverWait wait = null;

	private TestData testData = null;

	public TestExecutor(String xlsPath) {
		testData = new TestData(xlsPath);
		String URL = getURL();
		openBrowser(URL);
		wait = new WebDriverWait(dv, 60);
	}

	public void setTestDataSheetName(String testDataSheetName) {
		testData.setDataSheetName(testDataSheetName);
	}

	public TestData getTestData() {
		return testData;
	}

	private String getURL() {
		String URL = testData.getData(StaticData.envDetails, "URL");
		if (URL == null) {
			URL = testData.getData(StaticData.envDetails, "defaultURL");
		}
		return URL;
	}

	/* Common method for launching the browser */

	private void openBrowser(String URL) {
		String webDriverPath = null;
		if (testData.getData(StaticData.suitData, "Browser").equalsIgnoreCase("chrome")) {
			webDriverPath = testData.getData(StaticData.suitData, "ChromeDriverPath");
			System.setProperty("webdriver.chrome.driver", webDriverPath);
			dv = new ChromeDriver();
			logger.info("Google chrome browser is initializing now.");
		}

		else if (testData.getData(StaticData.suitData, "Browser").equalsIgnoreCase("firefox")) {
			webDriverPath = testData.getData(StaticData.suitData, "FFDriverPath");
			System.setProperty("webdriver.gecko.driver", webDriverPath);
			dv = new FirefoxDriver();
			logger.info("Firefox browser is initializing now.");
		}

		dv.manage().window().maximize();
		dv.get(URL);
		logger.info("Opening URL: "+URL);
		TestExecutorContainer.setTestExecutor(this);
	}

	/* Common method for creating By object */

	private By GetBy(String POMKey) {
		String type = testData.getPOM(POMKey).getType();
		String value = testData.getPOM(POMKey).getValue();
		if (type.equalsIgnoreCase("xpath"))
			return By.xpath(value);
		if (type.equalsIgnoreCase("id"))
			return By.id(value);
		if (type.equalsIgnoreCase("name"))
			return By.name(value);
		if (type.equalsIgnoreCase("linkText"))
			return By.linkText(value);
		if (type.equalsIgnoreCase("PartialLinkText"))
			return By.partialLinkText(value);
		if (type.equalsIgnoreCase("tagName"))
			return By.tagName(value);
		if (type.equalsIgnoreCase("className"))
			return By.className(value);
		return null;
	}

	/* Common method for different type of wait */

	public TestExecutor waitVisibilityOfElementBy(String POMKey) {
		By by = GetBy(POMKey);
		logger.info("Waiting for the visibility of the locator: "+POMKey+".");
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return this;
	}

	public TestExecutor waitToBeClickableBy(String POMKey) {
		By by = GetBy(POMKey);
		logger.info("Waiting until the "+POMKey+" is getting clickable.");
		wait.until(ExpectedConditions.elementToBeClickable(by));
		return this;
	}

	public TestExecutor implicitWait(int timeInMilliSec) throws Exception {
		logger.info("Waiting for: "+timeInMilliSec+"MilliSec.");
		Thread.sleep(timeInMilliSec);
		return this;
	}

	/* Common method for click */

	public TestExecutor clickBy(String POMKey) {
		By by = GetBy(POMKey);
		dv.findElement(by).click();
		return this;
	}

	/* Common method to clear a field */

	public TestExecutor clearById(String POMKey) {
		By by = GetBy(POMKey);
		dv.findElement(by).clear();
		return this;
	}

	/* Common method to select a drop-down value of a field */

	public TestExecutor selectDropdownBy(String POMKey, String text) {
		clickBy(POMKey);
		By by = GetBy(POMKey);
		Select dropdown = new Select(dv.findElement(by));
		dropdown.selectByVisibleText(text);
		return this;
	}

	/* Common method to send a string value for a field */

	public TestExecutor sendKeysBy(String POMKey) {
		By by = GetBy(POMKey);
		String value = testData.getPOM(StaticData.data, POMKey).getType();
		dv.findElement(by).sendKeys(value);
		return this;
	}

	/* Common method to get a string value from a field */

	public String getTextBy(String POMKey) {
		By by = GetBy(POMKey);
		return dv.findElement(by).getText();
	}

	/* Common method to verify page title */

	public TestExecutor verifyTitle(String expectedTitle) {
		String value = testData.getData(StaticData.pageTitle, expectedTitle);
		Assert.assertEquals(dv.getTitle(), value);
		logger.info(dv.getTitle()+": Page title has been verified.");
		return this;
	}

	/* Common method to take screenshot */

	public void takeScreenshot(String screenshotPath, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) dv;
			File scrFile = ts.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
			String path = testData.getData(StaticData.suitData, screenshotPath);
			StaticData.fileName = path + screenshotName + "_" + timestamp + ".png";
			FileUtils.copyFile(scrFile, new File(StaticData.fileName));
			if(!screenshotPath.equals("ScreenshotPath"))
				logger.info("Sacrrenshot of "+dv.getTitle()+" page has been captured.");
		} catch (Exception e) {
			logger.error("Exception while taking screenshot: " + e.getMessage());
		}
	}

	/* Create log file */

	public void writeLog(String msg) {
		logger.info(msg);
	}
	
	/*Get WebDriver*/
	
	public WebDriver getWebDriver() {
		return dv;
	}
	
	/*Switch to the tab using index number*/
	
	public TestExecutor switchToTab(int index) {
		try {
			ArrayList<String> tabs = new ArrayList<String> (dv.getWindowHandles());
			dv.switchTo().window(tabs.get(index));
			logger.info("Driver switch to "+dv.getTitle()+" page");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	    return this;
	}
	
	/*Close the tab using index number*/
	
	public TestExecutor closeTabByIndex(int index) {
		try {
			ArrayList<String> tabs = new ArrayList<String> (dv.getWindowHandles());
			dv.switchTo().window(tabs.get(index));
			dv.close();
			logger.info(dv.getTitle()+" page has been closed.");
			dv.switchTo().window(tabs.get(index-1));
			logger.info("Driver switch to "+dv.getTitle()+" page");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return this;
	}
	
}
