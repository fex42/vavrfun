package functional;

import org.junit.Test;

import java.util.function.Function;

public class FunctionalComposition {
    @Test
    public void functionCompose() {
        Function<Integer, Integer> add2 = e -> e + 2;
        Function<Integer, Integer> times2 = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;

        Integer input = 4;

        // compose from right to left
        Integer output1 = times2.compose(square).compose(add2).apply(input);

        // andThen from left to right
        Integer output2 = add2.andThen(square).andThen(times2).apply(input);

        System.out.println(output1 + ", " + output2);
    }
}
