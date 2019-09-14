package basic;

import java.nio.file.Paths;
import java.util.List;

import common.object.User;
import common.util.FilesUtils;
import json.JsonUtils;

public class AMain {

	public static void main(String[] args) {
		String json = FilesUtils.readFileToString(Paths.get("file/list.json"));
		List<User> list = JsonUtils.toList(json, User[].class);
		// System.out.println(list.size());
		for (User user : list) {
			System.out.println(user.toString());
		}
	}
}
