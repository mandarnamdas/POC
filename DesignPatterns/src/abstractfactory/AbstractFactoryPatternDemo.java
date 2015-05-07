package abstractfactory;

public class AbstractFactoryPatternDemo {


	public static void main(String[] args) {
		
		FactoryProducer fp = new FactoryProducer();
		AbstractFactory shapeFactory = fp.getFactory("SHAPE");
		Shape rect = shapeFactory.getShape("RECT");
		rect.draw();
		Shape circle = shapeFactory.getShape("CIRCLE");
		circle.draw();		
		
		
		AbstractFactory colourFactory = fp.getFactory("COLOUR");
		Colour red = colourFactory.getColour("RED");
		red.fillColour();
		Colour green = colourFactory.getColour("GREEN");
		green.fillColour();
		
	}
}
