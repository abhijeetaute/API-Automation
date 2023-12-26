package ecommerceAPI;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
	
	// get Payload as string
	public static String getCreateEmployeePayloadAsString(String name,long salary,int age) {
		return "{\"name\":\""+name+"\",\"salary\":"+salary+",\"age\":"+age+"}";
	}
	
	// get payload as Map
	public static Map<String,Object> getCreateEmployeePayloadAsMap(String name,long salary,int age) {
		
		Map<String, Object> payload=new HashMap<String,Object>();
		payload.put("name", name);
		payload.put("salary",salary );
		payload.put("age",age );
		
		return payload;
	}
}
