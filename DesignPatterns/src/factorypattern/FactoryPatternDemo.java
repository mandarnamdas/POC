package factorypattern;

public class FactoryPatternDemo {


	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape rect = factory.getShape("RECT");
		rect.draw();
		Shape circle = factory.getShape("CIRCLE");
		circle.draw();		
	}
}
