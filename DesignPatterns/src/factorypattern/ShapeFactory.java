package factorypattern;

public class ShapeFactory {
	
	public Shape getShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECT")) {
			return new Rectangle();
		}		
		return null;
	}
	
}
