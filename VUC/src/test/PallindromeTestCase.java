package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PallindromeTestCase {

    TestPallindrome classUnderTest;

    @Test
    public void testPalindromeClass() {
        classUnderTest = new TestPallindrome();
        assertNotNull(classUnderTest);
    }

    @Test
    public void whenPallindromeThenTrue() {
        classUnderTest = new TestPallindrome();
        assertTrue(classUnderTest.isPallindrome("MOM"));
    }

    @Test
    public void whenNotPallindromeThenFalse() {
        classUnderTest = new TestPallindrome();
        assertFalse(classUnderTest.isPallindrome("ABC"));
    }

    @Test
    public void whenNotPallindromeThenFalse_1() {
        classUnderTest = new TestPallindrome();
        assertFalse(classUnderTest.isPallindrome("ABCCCCCCCDDDDD"));
    }

}
