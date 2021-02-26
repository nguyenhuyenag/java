package patterns.creational.singleton.init;

public class StaticBlock {

	private static final StaticBlock INSTANCE;

	private StaticBlock() {

	}

	static {
		try {
			INSTANCE = new StaticBlock();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static StaticBlock getInstance() {
		return INSTANCE;
	}

}
