package test;

public class TestPallindrome {

    public boolean isPallindrome(String string) {
        return string.equals(getReverseOfString(string));
    }

    private String getReverseOfString(String string) {
        StringBuffer reverse = new StringBuffer(string);
        reverse.reverse();
        return reverse.toString();
    }

}
