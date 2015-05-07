package prototype;

public class Square extends Shape {

	public Square() {
		type="SQUARE";
	}
	@Override
	public void draw() {
		System.out.println("Draw SQUARE");
	}

}
