package ecommerceAPI;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import restUtils.RestUtils;

public class ApplicationUtils{
	
	public Response createProduct(Map<String,Object> payload) {
		
		return RestUtils.post(BaseClass.dataFromJson.get("APIEndPoint").toString(), payload, new HashMap<String, String>());
	} 

}
