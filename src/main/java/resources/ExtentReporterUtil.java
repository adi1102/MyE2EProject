package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtil {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject(){
		
	//
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter spark = new ExtentSparkReporter(path);
	spark.config().setDocumentTitle("Extent Test Results");
	spark.config().setReportName("Extent Report");
	
	extent = new ExtentReports();
	extent.attachReporter(spark);
	extent.setSystemInfo("Tester", "Aditya Murti");
	return extent;

}
	
}
