package abstractfactory;

public abstract class AbstractFactory {

	abstract public Shape getShape(String colourType);
	abstract public Colour getColour(String shapeType);
}
