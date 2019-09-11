package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrElseGet {

	private static List<String> getList() {
		return null;
	}

	private static Optional<List<String>> getList2() {
		return null;
	}

	public static void main(String[] args) {

		// Pre java 8
		List<String> list = getList();
		List<String> listOpt = list != null ? list : new ArrayList<>();
		System.out.println(listOpt.toString());

		// orElse()
		List<String> listOpt2 = getList2().orElse(new ArrayList<>());
		System.out.println(listOpt2.toString());

		// orElseGet()
		List<String> listOpt3 = getList2().orElseGet(() -> new ArrayList<>());
		System.out.println(listOpt3.toString());
		
	}
}
