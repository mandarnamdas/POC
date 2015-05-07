package com;

public class StaticTestClass {

	private String name;
	
	public StaticTestClass() {
		// Default constructor
	}
	
	public StaticTestClass(String name) {
		this.setName(name);
	}
	
	
	public static String sayHello(){
		System.out.println("Real implementation of sayHello");
		return "Helloooo";			
	}
	
	public static final String sayBye(){
		System.out.println("Real implementation of sayBye");
		return "Byee";
	}
	
	public String callPrivateMethod(){	
		System.out.println("Inside callPrivateMethod method");
		return saveDetails();
	}
	
	private String saveDetails(){
		System.out.println("Real implementation of saveDetails");
		return "saveDetails";
	}
	
	public void calculate() {
		System.out.println("Inside calculate method");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
