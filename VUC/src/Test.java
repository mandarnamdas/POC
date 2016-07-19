/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/*
 * You may add any imports here, if you wish, but only from the standard library
 */

/* Do not add a namespace declaration */
public class Test {

    public static void main(String[] args) {

        class A {

            public int x = 10;

            public void print() {
                System.out.println(this.x);
            }
        }

        class B extends A {

            public int x = 20;

            @Override
            public void print() {
                System.out.println(this.x);
            }
        }

        A a = new B();
        System.out.println(a.x);
        a.print();
    }
}
