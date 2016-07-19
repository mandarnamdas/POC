package sandesh;

public class Circle extends Shape {

    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int add(float a, float b) {
        return Integer.parseInt((a + b) + "");
    }
}
