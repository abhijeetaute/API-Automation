package reporting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.http.Header;

public class ExtentReportManager {
	
	public static ExtentReports extentReport;
	
	// method to create instance of extentreport and return
	public static ExtentReports createInstance(String fileName,String reportName,String docTitle) {
		ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(fileName);
		extentSparkReporter.config().setReportName(reportName);
		extentSparkReporter.config().setDocumentTitle(docTitle);
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setEncoding("utf-8");
		extentReport=new ExtentReports();
		extentReport.attachReporter(extentSparkReporter);
		return extentReport;
	}

	// get report name with time-stamp attached
	public static String getReportNameWithTimeStamp() {
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime localDateTime=LocalDateTime.now();
		String formattedDate=dateTimeFormatter.format(localDateTime);
		String reportName="TestReport_"+formattedDate+".html";
		return reportName;
	}
	
	// To log success message in green
	public static void logPassDetails(String log) {
		TestListener.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
	}
	
	// To log failure message in red 
	public static void logFailure(String log) {
		TestListener.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
	}
	
	// To log info message in grey
	public static void logInfo(String log) {
		TestListener.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
	}
	
	public static void logJson(String json) {
		TestListener.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
	}
	
	public static void logHeaders(List<Header> headerList) {
		String[][] arrayHeaders=headerList.stream().map(header->new String[]{header.getName(),header.getValue()}).toArray(String[][]::new);
		TestListener.extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
	}
	
	public static void logExceptionDetails(String exceptionDetails) {
		TestListener.extentTest.get().fail(exceptionDetails);
	}
}
