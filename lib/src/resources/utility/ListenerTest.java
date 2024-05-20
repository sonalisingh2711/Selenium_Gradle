package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest extends Helper implements ITestListener {

	@Override
	public void onFinish(ITestContext Result) {
	}

	@Override
	public void onStart(ITestContext Result) {
		logger.info("--------------------------TEST START---------------------------------");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

	// When Test case get failed, this method is called.
	@Override
	public void onTestFailure(ITestResult Result) {
		if (Result.getMethod().getMethodName().contains("Api")) {
			logger.error("Test Fail: " + Result.getMethod().getMethodName().toUpperCase() + "  REASON:  "
					+ Result.getThrowable().getMessage());
		} else {
			logger.error("Test Fail: " + Result.getMethod().getMethodName().toUpperCase() + "  REASON:  "
					+ Result.getThrowable().getMessage());
			screenshot(Result.getMethod().getMethodName());

		}
	}

	// When Test case get Skipped, this method is called.
	@Override
	public void onTestSkipped(ITestResult Result) {

	}

	// When Test case get Started, this method is called.
	@Override
	public void onTestStart(ITestResult Result) {
		logger.info("Test Start: " + Result.getMethod().getMethodName().toUpperCase());
	}

	// When Test case get passed, this method is called.
	@Override
	public void onTestSuccess(ITestResult Result) {
		logger.info("Test Executed Successfully: " + Result.getMethod().getMethodName().toUpperCase());
	}

}
