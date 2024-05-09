package basic.exception;

public class ExceptionMessage {

	public static void test() {
		String errorMessage = null;
		try {
			throw (new Exception("Let's throw some exception message here"));
		} catch (Exception e) {
			System.out.println("In Exception block");
			e.printStackTrace();
			System.out.println("ToString: " + e.toString());
			errorMessage = e.getMessage();
		} finally {
			System.out.println(errorMessage);
		}
	}

	public static void main(String[] args) {
		test();
	}

}
