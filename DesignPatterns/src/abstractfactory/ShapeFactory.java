package abstractfactory;

public class ShapeFactory extends AbstractFactory {
	
	public Shape getShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECT")) {
			return new Rectangle();
		}		
		return null;
	}

	public Colour getColour(String shapeType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
