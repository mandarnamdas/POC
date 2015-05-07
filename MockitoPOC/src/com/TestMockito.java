package com;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class TestMockito {

	@Mock
	private List<String> mockedList;
	
	@Spy
	private List<String> spyList = new ArrayList<String>();
	
	@InjectMocks
	private OrderPlacemetService classUnderTest = new OrderPlacemetService();
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testVerify() {
		classUnderTest.verify();
		verify(mockedList).add("One");
		verify(mockedList).clear();
	}
	
	@Test
	public void testStub() {
		when(mockedList.get(0)).thenReturn("First Val");
		classUnderTest.stub();
		verify(mockedList).get(0);
	}
	
	@Test
	public void testArgumentMatcher() {
		when(mockedList.get(anyInt())).thenReturn("Argument matcher successfull");		
		classUnderTest.argumentMatcher();
		verify(mockedList).get(anyInt());
	}
	
	@Test
	public void testArgumentCapture(){
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		classUnderTest.argumentCapture();
		verify(mockedList).add(captor.capture());
		System.out.println("Captured Argument ->"+captor.getValue());
	}
	
	@Test
	public void testMethodCalls(){
		classUnderTest.methodCalls();
		verify(mockedList, times(1)).add("one");
		verify(mockedList, times(2)).add("two");
		verify(mockedList, times(3)).add("three");
		verify(mockedList, never()).add("never called");		
	}
	
	@Test(expected=Exception.class)
	public void testThrowError(){
		doThrow(Exception.class).when(mockedList).clear();
		classUnderTest.throwError();
	}
	
	@Test
	public void testSpy(){
		List<String> mockedList = new ArrayList<String>();
		List<String> spy = spy(mockedList);
						
		//when(spy.get(0)).thenReturn("dddddddd");
		doReturn("First Object").when(spy).get(0);
		
		spy.add("One");
		spy.add("Two");
		
		System.out.println(spy.get(0));
		System.out.println(spy.get(1));
	}
	
	@Test
	public void testSpy1() throws Exception{		
		doReturn("First Object").when(spyList).get(0);		
		classUnderTest.spy();
	}
	
	@Test
	public void testResetMock(){
		mockedList.add("Object");
		verify(mockedList).add("Object");
		reset(mockedList);
		//verify(mockedList).add("Object");
	}
	
	/*@Test
	public void testStatic(){
		mock(StaticTestClass.class);
		when(StaticTestClass.sayHello()).thenReturn("Helloooo");		
		TestCase.assertEquals("Helloooo", StaticTestClass.sayHello());
		verify(StaticTestClass.class);
	}*/
}
