package prototype;

public class Circle extends Shape{

	public Circle() {
		type="CIRCLE";
	}
	
	@Override
	public void draw() {
		System.out.println("Draw CIRCLE");		
	}

}
