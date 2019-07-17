package functional.total;

public class TotalFunctions2IntegerDivide {

    public static void main(String[] args) {
        TotalFunctions2IntegerDivide app = new TotalFunctions2IntegerDivide();
        app.run();
    }

    public Integer divide(Integer dividend, Integer divisor) {
        return dividend / divisor;
    }

    private void run() {
        System.out.println("10 / 2 = " + divide(10, 2));
        System.out.println("9 / 2 = " + divide(9, 2));
        System.out.println("9 / 0 = " + divide(9, 0));
    }
}
