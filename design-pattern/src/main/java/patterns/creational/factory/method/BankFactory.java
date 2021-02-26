package patterns.creational.factory.method;

public class BankFactory {

	private BankFactory() {
		
	}

	public static final Bank getBank(BankType bankType) {
		switch (bankType) {
		case TPBANK:
			return new TPBank();
		case VIETCOMBANK:
			return new VietcomBank();
		default:
			throw new IllegalArgumentException("This bank type is unsupported");
		}
	}

}
