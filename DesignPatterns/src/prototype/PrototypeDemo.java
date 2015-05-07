package prototype;

public class PrototypeDemo {

	public static void main(String[] args) {
		
		Shape s1 = new Circle();
		
		System.out.println("------>"+s1.getType());
		
		Shape s2 = (Shape) s1.clone();
		
		System.out.println("------>"+s2.getType());
		
		s1.setType("Shallow Copy");
		
		System.out.println("------>"+s1.getType());
		
		System.out.println("------>"+s2.getType());
	}

}
