package common.util;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
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

public class JsonUtils {

	private static final Gson GSON = new Gson();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	private JsonUtils() {
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * JSON to object
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
	 * JSON to List object
	 * @param <T>
	 * @param json
	 * @param array
	 * List<User> list = JsonUtils.toList(json, User[].class);
	 * @return
	 */
	public static <T> List<T> toList(String json, Class<T[]> array) {
		return Arrays.asList(GSON.fromJson(json, array));
	}
	
	/**
	 * Object to JSON
	 * @param <T> generic type
	 * @param object Java object
	 * @return JSON
	 */
	public static <T> String fromObject(T object) {
		if (Objects.nonNull(object)) {
			try {
				return MAPPER.writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return StringUtils.EMPTY;
	}
	
	/**
	 * Colection to JSON
	 * @param <T>
	 * @param Colection
	 * @return JSON
	 */
	public static <T> String fromCollection(Collection<T> list) {
		return GSON.toJson(list);
	}
	
	/**
	 * XML to JSON
	 * @param path the path of xml
	 * @return JSON
	 */
	public static String fromXml(Path path) {
		String xml = FilesUtils.readFileToString(path).trim();
		JSONObject json = XML.toJSONObject(xml);
		return json.toString(4); // tab = 4
	}

	/**
	 * XML to JSON
	 * @param file the path of xml
	 * @return JSON
	 */
	public static String fromXml(File file) {
		return fromXml(file.toPath());
	}

}
