package com.scinter.www.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonMapper {

	private static final ObjectMapper mapper = new ObjectMapper();
	private JacksonMapper() {}
	public static ObjectMapper getInstance() {
		return mapper;
	}

	public static String compressStringList(List<String> objects) {
		String value = "";
		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			value = mapper.writeValueAsString(objects);
		} catch (JsonGenerationException e) {
			// Do nothing
		} catch (IOException e) {
			// Do nothing
		}
		return value;
	}

	public static List<String> extractList(String jsonString) {
		List<String> list= new ArrayList<String>();

		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			list = mapper.readValue(jsonString, ArrayList.class);
		} catch (JsonParseException e) {
			// Do nothing
		} catch (IOException e) {
			// Do nothing
		}

		return list;
	}
}
