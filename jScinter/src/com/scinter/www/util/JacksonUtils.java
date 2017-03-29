package com.scinter.www.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JacksonUtils {

	public static <T> List<T> extractList(String listString, TypeReference<List<T>> type) {

		if (listString == null) return new ArrayList<T>();

		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			return mapper.readValue(listString, type);
		} catch (JsonParseException e) {
			e.printStackTrace();
			// Do nothing
		} catch (IOException e) {
			e.printStackTrace();
			// Do nothing
		}
		return new ArrayList<T>();
	}
	
	public static <T> List<T> extractList(String listString, List<T> list) {

		if (listString == null) return list;

		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			list = mapper.readValue(listString, list.getClass());
		} catch (JsonParseException e) {
			// Do nothing
		} catch (IOException e) {
			// Do nothing
		}
		return list;
	}

	public static <T> String compressList(List<T> list) {
		String listString = "";
		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			listString = mapper.writeValueAsString(list);
		} catch (JsonGenerationException e) {
			// Do nothing
		} catch (IOException e) {
			// Do nothing
		}
		return listString;
	}

	public static <T, S> Map<T, S> extractMap(String mapString, Map<T, S> map) {

		if (mapString == null) return map;

		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			map = mapper.readValue(mapString, map.getClass());
		} catch (JsonParseException e) {
			// Do nothing
		} catch (IOException e) {
			// Do nothing
		}
		return map;
	}

	public static <T, S> String compressMap(Map<T, S> map) {
		String mapString = "";
		ObjectMapper mapper = JacksonMapper.getInstance();
		try {
			mapString = mapper.writeValueAsString(map);
		} catch (JsonGenerationException e) {
			// Do nothing
		} catch (IOException e) {
			// Do nothing
		}
		return mapString;
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("html_content", "1");
		map.put("css_content", "2");
		String output = compressMap(map);
		System.out.println(output);
	}
}
