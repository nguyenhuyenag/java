package learn.json;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.object.User;
import common.util.FilesUtils;

public class JSONToObject {

	public static void main(String[] args) 
			throws JsonParseException, JsonMappingException, IOException {
		String json = FilesUtils.readFileToString(Paths.get("file/user.json"));
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<User>> type = new TypeReference<List<User>>() {};
		List<User> details = mapper.readValue(json, type);
		details.forEach(d -> System.out.println(d.toString()));
	}

}