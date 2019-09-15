package json;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.json.XML;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import common.util.FilesUtils;

public class JsonUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private JsonUtils() {
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Object to JSON
	 * @param <T> generic type
	 * @param object Java object
	 * @return JSON
	 */
	public static <T> String objectToJson(T object) {
		if (Objects.isNull(object)) {
			return StringUtils.EMPTY;
		}
		try {
			return MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}

	/**
	 * JSON to object
	 * @param <T> generic type
	 * @param json
	 * @param type
	 * @return Java object
	 */
	public static <T> T jsonToObject(String json, Type type) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.enableComplexMapKeySerialization().create();
		return gson.fromJson(json, type);
	}

	/**
	 * JSON to List object
	 * @param <T>
	 * @param json
	 * @param array
	 * List<User> list = JsonUtils.toList(json, User[].class);
	 * @return
	 */
	public static <T> List<T> toList(String json, Class<T[]> array) {
		Gson gson = new Gson();
		return Arrays.asList(gson.fromJson(json, array));
	}
	
	/**
	 * XML to JSON
	 * @param path the path of xml
	 * @return JSON
	 */
	public static String xmlToJson(Path path) {
		String xml = FilesUtils.readFileToString(path).trim();
		JSONObject json = XML.toJSONObject(xml);
		return json.toString(4); // tab = 4
	}

	public static String xmlToJson(File file) {
		return xmlToJson(file.toPath());
	}

}
