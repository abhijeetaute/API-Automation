package restUtils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUtils {

	public static Response post(String endpoint, String requestPayload, Map<String, String> headers) {

		return RestAssured.given().log().all()
				.baseUri(endpoint)
				.headers(headers)
				.contentType(ContentType.JSON)
				.body(requestPayload)
				.post()
				.then().log().all().extract().response();
	}

	
	public static Response post(String endpoint, Map<String,Object> requestPayload, Map<String, String> headers) {

		return RestAssured.given().log().all()
				.baseUri(endpoint)
				.headers(headers)
				.contentType(ContentType.JSON)
				.body(requestPayload)
				.post()
				.then().log().all().extract().response();
	}

}
