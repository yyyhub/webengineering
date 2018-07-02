package common.utils;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static String mapToJson(Map<String, Object> result) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
			String json=mapper.writeValueAsString(result);
		return json;
	}

}
