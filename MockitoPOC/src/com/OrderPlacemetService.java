package com;

import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

public class OrderPlacemetService {

	private List<String> mockedList = new ArrayList<String>();
	
	private List<String> spyList = new ArrayList<String>();
	
	public void verify(){
		mockedList.add("One");
		mockedList.clear();		
	}
	
	public void stub() {
		System.out.println(mockedList.get(0));
	}
	
	public void argumentMatcher() {
		System.out.println(mockedList.get(999));	
	}
	
	public void argumentCapture(){
		mockedList.add("Argument");
	}
	
	public void methodCalls(){
		mockedList.add("one");
		mockedList.add("two");mockedList.add("two");
		mockedList.add("three");mockedList.add("three");mockedList.add("three");
	}
	
	public void throwError(){
		mockedList.clear();
	}
	
	public void spy(){		
		spyList.add("One");
		spyList.add("Two");
		System.out.println(spyList.get(0));
		System.out.println(spyList.get(1));
	}
}
