package builder;

public abstract class Burger implements Item {

	@Override
	abstract public String name();

	@Override
	abstract public float price();

	@Override
	public Packing  packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}

	

}
