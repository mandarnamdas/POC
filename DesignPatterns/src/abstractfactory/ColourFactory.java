package abstractfactory;

public class ColourFactory extends AbstractFactory {
	
	public Colour getColour(String colourType) {
		if (colourType.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (colourType.equalsIgnoreCase("GREEN")) {
			return new Green();
		}
		return null;
	}

	public Shape getShape(String colourType) {
		// TODO Auto-generated method stub
		return null;
	}

}
