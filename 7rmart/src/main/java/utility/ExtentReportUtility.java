package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	public static ExtentReports extentReports=new ExtentReports();
	public synchronized static ExtentReports createExtentReports()
	{
		ExtentSparkReporter reporter =new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("demoproject");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("organization", "obsqura");
		extentReports.setSystemInfo("name", "anjana");
		return extentReports;
		
	}

}

