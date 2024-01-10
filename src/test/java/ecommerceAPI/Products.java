package ecommerceAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restUtils.RestUtils;
import utils.JsonUtils;

public class Products extends BaseClass{
	
	//https://dummy.restapiexample.com/create
	
	
	@Test
	public void createProduct() throws Exception {
		Map<String,Object> payload=Payloads.getCreateEmployeePayloadAsMap("TestUser1",30001,24);
		Response response=new ApplicationUtils().createProduct(payload);
		Assert.assertEquals(response.statusCode(), 200);
		
	}

}
