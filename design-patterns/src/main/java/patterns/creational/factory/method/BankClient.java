package patterns.creational.factory.method;

public class BankClient {

	public static void main(String[] args) {

		Bank tpBank = BankFactory.getBank(BankType.TPBANK);
		System.out.println(tpBank.getBankName()); // TPBank

		Bank vcBank = BankFactory.getBank(BankType.VIETCOMBANK);
		System.out.println(vcBank.getBankName()); // VietcomBank

	}

}
