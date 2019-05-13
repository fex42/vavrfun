package functional;

import org.junit.Test;

public class ImmutableOrNot {

    @Test
    public void stringUniqueness() {
        String s1 = "Foo";
        String s2 = "Foo";

        boolean isSameS1S2 = s1 == s2;

        System.out.println("isSameS1S2: " + isSameS1S2); // true
    }

    @Test
    public void stringUniqueness2() {
        String s1 = "Foo";
        String s2 = new String("Foo");

        boolean isSameS1S2 = s1 == s2;

        System.out.println("isSameS1S2: " + isSameS1S2); // false
    }

    @Test
    public void stringUniqueness3() {
        String s1 = "Foo";
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        String s2 = sb.toString();

        boolean isSameS1S2 = s1 == s2;

        System.out.println("isSameS1S2: " + isSameS1S2); // false
    }
}
