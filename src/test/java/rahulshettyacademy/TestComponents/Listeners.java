package rahulshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import rahulshettyacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	
	ExtentReports extent = ExtentReporterNG.config();
	ExtentTest test;//holds entry to the testcase
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//every class running concurrently will have separate threads created
	
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//maps the unique thread value of Errorvalidation Test to its object i:e test
		//inside the extentTest class a unique id is mapped opposite to test object
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	    
		//in place the the test object used earlier to call functions , now we use extentTest.get() method
		//extentTest.get() method will extract the unique thread value of Errorvalidation Test
		//test.log(Status.PASS, "Test Passes");
		extentTest.get().log(Status.PASS, "Test Passes");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		 String filePath = null;
		
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			//getTestClass() - gets the classname in testng file the testcase is referring to
			//getRealClass() -  it will actually go into the class froom the testng file
			//getField("driver") - from that class it will get whatever field the driver is pointing
			//that field will give life to the driver to be used as argument below
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//attach screenshot
		 //test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

	
}
