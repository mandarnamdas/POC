package singletonpattern;

public class SingleFactoryDemo {

	public static void main(String[] args) {
		
		SingletonObject obj = SingletonObject.getInstance();
		obj.showMwssage();
		SingletonObject obj1 = SingletonObject.getInstance();
		obj.showMwssage();
	}

}
