package reporting;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener{

	private static ExtentReports extentReport;
	public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onStart(ITestContext context) {
		String fileName=ExtentReportManager.getReportNameWithTimeStamp();
		String filePath=System.getProperty("user.dir")+"\\report\\"+TestReport.html;
		extentReport=ExtentReportManager.createInstance(filePath,"Extent Automation Report", "Automation Report");
	}
	
	public void onFinish(ITestContext context) {
		if(extentReport!=null)
			extentReport.flush();
	}
	
	public void onTestStart(ITestResult result) {
		ExtentTest test=extentReport.createTest("Test Case -"+result.getTestClass().getName()+" - "+result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.logFailure(result.getThrowable().getMessage());
		String stackTrace=Arrays.toString(result.getThrowable().getStackTrace());
		stackTrace=stackTrace.replaceAll(",","<br>");
		String formattedTrace="<details>\n"+
							  "<summary> Click to see exception logs</summary>\n"+
							  stackTrace+"\n"
							  		+ "</details>\n";
		ExtentReportManager.logExceptionDetails(formattedTrace);
	}
	
}
