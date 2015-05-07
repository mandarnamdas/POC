package singletonpattern;

public class SingletonObject {

	private static SingletonObject object = null;
	
	private SingletonObject() {
		System.out.println("Provate Constructor");
	}
	
	public static SingletonObject getInstance() {
		
		if (object == null) {
			synchronized (SingletonObject.class) {
				if (object == null) {
					System.out.println("IFFFFFFFF");
					object = new SingletonObject();		
				}
			}
		}
		return object;
	}
	
	public void showMwssage () {
		System.out.println("This is Singleton Test");
	}
}
