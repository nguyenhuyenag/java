package patterns.creational.abstracts.factory;

public class PlasticChair implements Chair {
	
	@Override
	public void create() {
		System.out.println("Create plastic chair");
	}
	
}