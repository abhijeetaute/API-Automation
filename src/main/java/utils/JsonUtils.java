package utils;

import java.io.File;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	// get json file data as map
	@SuppressWarnings("unchecked")
	public static Map<String,Object> getJsonDataAsMap(String jsonFileName) throws Exception{
		String filePath=System.getProperty("user.dir")+"/src/test/resources/"+jsonFileName;
		ObjectMapper objectMapper=new ObjectMapper();
		Map<String,Object> map=objectMapper.readValue(new File(filePath), Map.class);
		return map;
	}
}