package builder;

public class Pepsi extends Coldrink {

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 2.5f;
	}

}
