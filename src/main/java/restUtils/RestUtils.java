package restUtils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

public class RestUtils {

	private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload,Map<String,String> headers) {
		return RestAssured.given()
		.baseUri(endpoint)
		.headers(headers)
		.contentType(ContentType.JSON)
		.body(requestPayload);
	}
	
	private static void printRequestLogInReport(RequestSpecification requestSpecification) {
		QueryableRequestSpecification queryableRequestSpecification=SpecificationQuerier.query(requestSpecification);
		ExtentReportManager.logInfo("Request Details are .......");
		ExtentReportManager.logInfo("Endpoint - "+queryableRequestSpecification.getBaseUri());
		ExtentReportManager.logInfo("Method - "+queryableRequestSpecification.getMethod());
		ExtentReportManager.logInfo("Request Headers are ");
		ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
		ExtentReportManager.logInfo("Request body is ");
		ExtentReportManager.logJson(queryableRequestSpecification.getBody());
	}
	
	private static void printResponseLogInReport(Response response) {
		ExtentReportManager.logPassDetails("ResponseDetails are .......");
		ExtentReportManager.logPassDetails("Response status - "+response.statusCode());
		ExtentReportManager.logPassDetails("Response Headers are ");
		ExtentReportManager.logHeaders(response.getHeaders().asList());
		if(response.getBody()!=null) {
		ExtentReportManager.logInfo("Request body is ");
		ExtentReportManager.logJson(response.getBody().prettyPrint());
		}
	}
	
	
	public static Response post(String endpoint, String requestPayload, Map<String, String> headers) {
		RequestSpecification requestSpecification=getRequestSpecification(endpoint, requestPayload, headers);
		Response response= requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}

	
	public static Response post(String endpoint, Map<String,Object> requestPayload, Map<String, String> headers) {
		RequestSpecification requestSpecification=getRequestSpecification(endpoint, requestPayload, headers);
		Response response= requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}

}
