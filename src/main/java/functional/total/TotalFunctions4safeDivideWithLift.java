package functional.total;

import io.vavr.Function2;
import io.vavr.control.Option;

public class TotalFunctions4safeDivideWithLift {

    public static void main(String[] args) {
        TotalFunctions4safeDivideWithLift app = new TotalFunctions4safeDivideWithLift();
        app.run();
    }

    public Integer divide(Integer dividend, Integer divisor) {
        return dividend / divisor;
    }

    Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift((Integer dividend, Integer divisor) -> divide(dividend, divisor));

    public String optInt2String(Option<Integer> option) {
        return option.map(Object::toString).orElse(Option.of("no value")).get();
    }

    private void run() {
        final Option<Integer> r1 = safeDivide.apply(10, 2);
        final Option<Integer> r2 = safeDivide.apply(9, 2);
        final Option<Integer> r3 = safeDivide.apply(9, 0);

        System.out.println("10 / 2 = " + optInt2String(r1));
        System.out.println("9 / 2 = " + optInt2String(r2));
        System.out.println("9 / 0 = " + optInt2String(r3));
    }
}
