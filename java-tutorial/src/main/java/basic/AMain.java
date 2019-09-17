package basic;

class A {
	void show() {
		System.out.println("show A");
	}
}

public class AMain extends A {

	// @Override
	void show() {
		super.show();
		// System.out.println("show main");
	}

	public static void main(String[] args) {

		// String dir =
		// "D:\\Java\\workspace\\maven\\java-all\\java-tutorial\\src\\main\\java\\basic";
		// System.out.println(PathUtils.toUnixSeparator(dir));
		// List<String> list = FilesUtils.listFileName(Paths.get(dir));
		// list.forEach(System.out::println);
		// System.out.println(Arrays.toString(list.stream().toArray(String[]::new)));
		
		AMain a = new AMain();
		a.show();
	}
}
