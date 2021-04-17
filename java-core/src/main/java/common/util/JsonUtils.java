package common.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

	private static final Gson GSON = new Gson();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	private JsonUtils() {
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * JSON to Object
	 * @param <T> generic type
	 * @param json
	 * @param type
	 * @return Java object
	 */
	public static <T> T toObject(String json, Type type) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.enableComplexMapKeySerialization().create();
		return gson.fromJson(json, type);
	}
	
	/**
	 * Object to JSON
	 * @param <T> generic type
	 * @param object Java object
	 * @return JSON
	 */
	public static <T> String toJSON(T object) {
		if (Objects.nonNull(object)) {
			try {
				return MAPPER.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	/**
	 * InputStream to Object
	 * @param is InputStream
	 * @param type class type
	 * @return object
	 */
	public static <T> T readValue(InputStream is, Class<T> type) {
		if (Objects.nonNull(is)) {
			try {
				return MAPPER.readValue(is, type);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	/**
	 * JSON to List Object
	 * @param <T>
	 * @param json
	 * @param array
	 * @return
	 */
	public static <T> List<T> toList(String json) {
		try {
			return MAPPER.readValue(json, new TypeReference<List<T>>() {});
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * JSON to List Object with GSON
	 * 
	 * List<User> list = JsonUtils.toList(json, User[].class);
	 */
	public static <T> List<T> toListWithoutCommon(String json, Class<T[]> array) {
		return Arrays.asList(GSON.fromJson(json, array));
	}
	
	/**
	 * Colection to JSON
	 * @param <T>
	 * @param Colection
	 * @return JSON
	 */
	public static <T> String collectionToJSON(Collection<T> list) {
		return GSON.toJson(list);
	}
	
	/**
	 * XML to JSON
	 * @param path the path of xml
	 * @return JSON
	 */
	public static String xmlToJSON(Path path) {
		String xml = FilesUtils.readFile(path).trim();
		JSONObject json = XML.toJSONObject(xml);
		return json.toString(4); // tab = 4
	}

	/**
	 * XML to JSON
	 * @param file the path of xml
	 * @return JSON
	 */
	public static String xmlToJSON(File file) {
		return xmlToJSON(file.toPath());
	}

}
