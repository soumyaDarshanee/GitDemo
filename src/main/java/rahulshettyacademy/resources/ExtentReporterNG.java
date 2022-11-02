package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports config()
	{
		//ExtentSparkReporter---helper class..stores basic config and path of report
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//creates html file and do configuration
		reporter.config().setReportName("WebAutomationResults");
		reporter.config().setDocumentTitle("TestResults");
		//ExtentReports,
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saumya");
		return extent;
	
	
	}

}
