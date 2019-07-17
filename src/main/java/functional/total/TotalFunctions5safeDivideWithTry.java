package functional.total;

import io.vavr.control.Try;

public class TotalFunctions5safeDivideWithTry {

    public static void main(String[] args) {
        TotalFunctions5safeDivideWithTry app = new TotalFunctions5safeDivideWithTry();
        app.run();
    }

    public Integer divide(Integer dividend, Integer divisor) {
        return dividend / divisor;
    }

    public Try<Integer> safeDivide(Integer dividend, Integer divisor) {
        return Try.<Integer>of(() -> divide(dividend, divisor));
    }

    private void run() {


        Try<Integer> r1 = safeDivide(10, 2);
        Try<Integer> r2 = safeDivide(9, 2);
        Try<Integer> r3= safeDivide(9, 0);

        System.out.println("10 / 2 = " + r1);
        System.out.println("9 / 2 = " + r2);
        System.out.println("9 / 0 = " + r3);
    }
}
