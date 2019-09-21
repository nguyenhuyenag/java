package patterns.creational.abstracts.factory;

public class FlasticFactory extends FurnitureAbstractFactory {

	@Override
	public Chair createChair() {
		return new PlasticChair();
	}

	@Override
	public Table createTable() {
		return new PlasticTable();
	}

}
