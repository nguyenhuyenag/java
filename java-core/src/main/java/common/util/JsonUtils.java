package common.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {

	// private static final Gson GSON = new Gson();
	private static final ObjectMapper MAPPER = new ObjectMapper();

	private JsonUtils() {
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * Object to JSON String
	 * 
	 * @param <T>    generic type
	 * @param object Java object
	 * @return JSON
	 */
	public static String toJSON(Object object) {
		if (object != null) {
			try {
				return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * JSON to Object
	 * 
	 * @return Java object
	 */
	public static <T> T toObject(String jsonString, Type type) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.enableComplexMapKeySerialization().create();
		return gson.fromJson(jsonString, type);
	}

	public static com.fasterxml.jackson.databind.JsonNode toJsonNode(String jsonString) {
		try {
			return MAPPER.readTree(jsonString);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

//	/**
//	 * Convert JSON string to JSONObject
//	 * 
//	 * @param jsonString is a JSON string
//	 * @return JSONObject
//	 * @see {@link JSONObject#get("fieldname")}}
//	 */
//	public static org.json.JSONObject toJSONObject(String jsonString) {
//		return new JSONObject(jsonString);
//	}

	/**
	 * JSON to List Object
	 */
	public static <T> List<T> toList(String jsonStringArray, Class<T> classT) {
		// return MAPPER.readValue(json, new TypeReference<List<T>>() {
		List<T> list = new ArrayList<>();
		org.json.JSONArray jsonArray = new JSONArray(jsonStringArray);
		for (Object json : jsonArray) {
			T t = new Gson().fromJson(json.toString(), classT);
			list.add(t);
		}
		return list;
	}

	// List to JSON array
	public static String toJSONArray(List<?> list) {
		JSONArray jarr = new JSONArray(list);
		return jarr.toString();
	}

	/**
	 * Colection to JSON
	 * 
	 * @return JSON
	 * @throws JsonProcessingException
	 */
	public static <T> String collectionToJson(Collection<T> list) {
		// return GSON.toJson(list);
		try {
			return MAPPER.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * InputStream to Object
	 * 
	 * @param is   InputStream
	 * @param type class type
	 * @return object
	 */
	public static <T> T readValue(InputStream is, Class<T> type) {
		if (is != null) {
			try {
				return MAPPER.readValue(is, type);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Convert InputStream to JsonObject
	 * 
	 * @param is InputStream
	 * @return JsonObject
	 * @see {@link JsonObject#getBoolean("fieldname")}
	 */
//	public static javax.json.JsonObject toJsonObject(InputStream is) {
//		if (is != null) {
//			try (javax.json.JsonReader jsonReader = Json.createReader(is)) {
//				return jsonReader.readObject();
//			}
//		}
//		return null;
//	}

//	/**
//	 * JSON to List Object with GSON
//	 * 
//	 * List<User> list = JsonUtils.toList(json, User[].class);
//	 */
//	public static <T> List<T> toListWithoutCommon(String json, Class<T[]> array) {
//		return Arrays.asList(GSON.fromJson(json, array));
//	}

//	/**
//	 * XML to JSON
//	 * @param path the path of xml
//	 * @return JSON
//	 */
//	public static String xmlToJSON(Path path) {
//		String xml = FilesUtils.readFile(path).trim();
//		JSONObject json = XML.toJSONObject(xml);
//		return json.toString(4); // tab = 4
//	}
//
//	/**
//	 * XML to JSON
//	 * @param file the path of xml
//	 * @return JSON
//	 */
//	public static String xmlToJSON(File file) {
//		return xmlToJSON(file.toPath());
//	}

}
