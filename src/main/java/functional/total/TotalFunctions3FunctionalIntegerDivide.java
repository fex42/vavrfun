package functional.total;

import io.vavr.Function2;

public class TotalFunctions3FunctionalIntegerDivide {

    public static void main(String[] args) {
        TotalFunctions3FunctionalIntegerDivide app = new TotalFunctions3FunctionalIntegerDivide();
        app.run();
    }

    Function2<Integer, Integer, Integer> divide = (dividend, divisor) -> dividend / divisor;

    private void run() {
        System.out.println("10 / 2 = " + divide.apply(10, 2));
        System.out.println("9 / 2 = " + divide.apply(9, 2));
        System.out.println("9 / 0 = " + divide.apply(9, 0));
    }
}
