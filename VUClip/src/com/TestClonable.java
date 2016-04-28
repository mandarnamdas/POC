package com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestClonable implements Serializable {

    public static void main(String[] args) throws CloneNotSupportedException, Exception {

        ClonableClass clone = new TestClonable().new ClonableClass();
        clone.setCount(10);
        clone.setB(new TestClonable().new B("Mandar"));
        clone.printCount();
        // Shallow Copy
        System.out.println("Shallow Copy");
        ClonableClass c1 = (ClonableClass) clone.clone();
        c1.printCount();
        c1.setCount(20);
        c1.getB().setName("Namdas");
        c1.printCount();
        clone.printCount();

        // Deep Copy
        System.out.println("Deep Copy");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(clone);
        out.flush();
        out.close();

        // Make an input stream from the byte array and read
        // a copy of the object back in.
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        ClonableClass c2 = (ClonableClass) in.readObject();
        c2.printCount();
        c2.setCount(20);
        c2.getB().setName("deep copy");
        c2.printCount();
        clone.printCount();

    }

    class ClonableClass implements Cloneable, Serializable {

        int count;

        B b;

        public void setCount(int count) {
            this.count = count;
        }

        public void setB(B b) {
            this.b = b;
        }

        public B getB() {
            return this.b;
        }

        public void printCount() {
            System.out.println(count + b.getName() + this.hashCode());
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
            // ClonableClass c = new ClonableClass();
            // c.setB(new B("Mandar"));
            // c.setCount(count);
            // return c;
        }
    }

    class B implements Serializable {

        String name;

        public B(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
