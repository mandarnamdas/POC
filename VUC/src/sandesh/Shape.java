package sandesh;

public class Shape {

    public void draw() {
        System.out.println("Draw shape");
    }

    public static void main(String[] args) {

        Shape s = new Shape();
        s.draw();

        s = new Circle();
        s.draw();

        Circle c = new Circle();
        System.out.println(c.add(4f, 5f));

        s = new Rect();
        s.draw();
    }
}
