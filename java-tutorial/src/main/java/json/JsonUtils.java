package json;

import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import common.object.User;
import common.util.FilesUtils;

public class JsonUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private JsonUtils() {
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static <T> String toJson(T object) {
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

	public static <T> T toObject(String json, Type type) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.enableComplexMapKeySerialization().create();
		return gson.fromJson(json, type);
	}

	public static <T> List<T> toList(String json, Class<T[]> array) {
		Gson gson = new Gson();
		return Arrays.asList(gson.fromJson(json, array));
	}

	public static void main(String[] args) {
		String json = FilesUtils.readFileToString(Paths.get("file/list.json"));
		List<User> list = JsonUtils.toList(json, User[].class);
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

}
