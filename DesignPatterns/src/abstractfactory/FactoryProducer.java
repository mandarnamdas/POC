package abstractfactory;

public class FactoryProducer {

	public AbstractFactory getFactory(String factoryType) {
		if (factoryType.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if (factoryType.equalsIgnoreCase("COLOUR")) {
			return new ColourFactory();
		}
		return null;
	}
}
