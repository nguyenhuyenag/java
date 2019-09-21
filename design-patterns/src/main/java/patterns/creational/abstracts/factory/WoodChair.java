package patterns.creational.abstracts.factory;

public class WoodChair implements Chair {

	@Override
	public void create() {
		System.out.println("Create wood chair");
	}

}
