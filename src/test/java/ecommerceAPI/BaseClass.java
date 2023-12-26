package ecommerceAPI;

import java.util.Map;

import org.testng.annotations.BeforeTest;

import utils.JsonUtils;

public class BaseClass {
	
	public static Map<String,Object> dataFromJson;
	@BeforeTest
	public void beforeTest() {
		try {
			dataFromJson=JsonUtils.getJsonDataAsMap("ecommerceAPI/ecommerceAPIData.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
