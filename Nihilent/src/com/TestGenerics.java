package com;

public class TestGenerics {

    class GenericClass<T, T1> {

        private T t;

        private T1 t1;

        public void setValue(T t) {
            this.t = t;
        }

        public void printValue() {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        GenericClass<String, Integer> tg = new TestGenerics().new GenericClass<String, Integer>();
        tg.setValue("Mandar");
        tg.printValue();

        GenericClass<Integer, Integer> tg1 = new TestGenerics().new GenericClass<Integer, Integer>();
        tg1.setValue(1);
        tg1.printValue();

    }
}
