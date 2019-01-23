package listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.TestExecutor;
import utility.TestExecutorContainer;
import utility.data.StaticData;

public class TestNGListeners implements ITestListener {

	private static final Logger logger = LoggerFactory.getLogger(TestNGListeners.class);

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TestExecutor te = TestExecutorContainer.getTestExecutor();
		te.takeScreenshot("FailedScreenshotPath", result.getName());
		logger.error("Testcase " + result.getName() + " has been failed. Please check the screenshot in the mentioned path below" + ": " + StaticData.fileName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Testcase " + result.getName() + " has been skipped.");
	}

	@Override
	public void onTestStart(ITestResult result) {

		logger.info("Testcase " + result.getName() + " has been started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Testcase " + result.getName() + " has been succeeded.");
	}

}
