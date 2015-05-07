package com;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;
import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticTestClass.class)
public class TestPowerMock extends TestCase{
 
	@Test
	public void testStatic() {		
		mockStatic(StaticTestClass.class);
		when(StaticTestClass.sayHello()).thenReturn("Helloooo");
		assertEquals("Helloooo", StaticTestClass.sayHello());
		verify(StaticTestClass.class);
	}
	
	@Test
	public void testFinal(){
		mockStatic(StaticTestClass.class);
		when(StaticTestClass.sayBye()).thenReturn("Byee");
		assertEquals("Byee", StaticTestClass.sayBye());
		verify(StaticTestClass.class);
	}
	
	@Test
	public void testPrivate() throws Exception{
		StaticTestClass classUnderTest = new StaticTestClass();
		StaticTestClass partialMock = spy(classUnderTest);		
		doReturn("Success").when(partialMock,"saveDetails");
		String result = partialMock.callPrivateMethod();
		
		assertEquals("Success", result);
	}
	
	@Test
	public void testPrivateInvoke() throws Exception{
		StaticTestClass classUnderTest = new StaticTestClass();
		Whitebox.invokeMethod(classUnderTest, "saveDetails");
	}
	
	@Test
	public void testNewObject() throws Exception {
		StaticTestClass classUnderTest = mock(StaticTestClass.class);
		when(classUnderTest.getName()).thenReturn("New Object");
		whenNew(StaticTestClass.class).withNoArguments().thenReturn(classUnderTest);
		assertEquals(new StaticTestClass().getName(), "New Object");
	}
	
	@Test
	public void testConstructor() throws Exception {
		StaticTestClass classUnderTest = mock(StaticTestClass.class);
		when(classUnderTest.getName()).thenReturn("New Name");
		whenNew(StaticTestClass.class).withArguments("Mandar").thenReturn(classUnderTest);
		assertEquals(new StaticTestClass("Mandar").getName(), "New Name");
	}
}
