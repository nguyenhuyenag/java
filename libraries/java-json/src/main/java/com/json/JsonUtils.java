package com.json;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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

    /*-
        Object to JSON String
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
        Gson gson = builder.enableComplexMapKeySerialization()
                .create();
        return gson.fromJson(jsonString, type);
    }

    // GitHubUser resource = RetrieveUtil.retrieveResourceFromResponse(response, GitHubUser.class);
    public static <T> T retrieveResourceFromResponse(HttpResponse response, Class<T> clazz) throws IOException {
        String jsonFromResponse = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper() //
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonFromResponse, clazz);
    }

    public static com.fasterxml.jackson.databind.JsonNode toJsonNode(String jsonString) {
        try {
            return MAPPER.readTree(jsonString);
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

    /*-
        JSON to List Object

        List<Employee> employeeList = objectMapper.readValue(file, new TypeReference<>(){});

        Map<String, Object> employee = objectMapper.readValue(file, new TypeReference<>(){});
     */
    public static <T> List<T> toList(String jsonStringArray, Class<T> classT) {
        // return MAPPER.readValue(json, new TypeReference<List<T>>(){})
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

    /*-
        Collection to JSON
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
     * Map<String, String> asMap = asType(s);
     */
    public static Map<String, String> asMap(String json) {
        if (StringUtils.isNotEmpty(json)) {
            try {
                return MAPPER.readValue(json, new TypeReference<Map<String, String>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyMap();
    }

//	/**
//	 * Convert InputStream to JsonObject
//	 *
//	 * @see {@link JsonObject#getBoolean("fieldname")}
//	 */
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

    public static void main(String[] args) {
        String s = "{\"id\":\"9221041e-d9ff-43f8-a894-2fe58905b8f9\",\"app_name\":\"TKTX\",\"date\":\"2023-05-10 08:46:01\",\"request_type\":3,\"taxnumber\":\"0309478306888\",\"val\":0,\"state\":\"1\",\"message\":\"pepsicoca113@gmail.com\",\"json\":null}";
        Map<String, String> asMap = asMap(s);
        System.out.println(asMap);
    }

}
