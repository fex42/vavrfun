package functional.total;

public class TotalFunctions1intDivide {

    public static void main(String[] args) {
        TotalFunctions1intDivide app = new TotalFunctions1intDivide();
        app.run();
    }

    public int divide(int dividend, int divisor) {
        return dividend / divisor;
    }

    private void run() {
        System.out.println("10 / 2 = " + divide(10, 2));
        System.out.println("9 / 2 = " + divide(9, 2));
        System.out.println("9 / 0 = " + divide(9, 0));
    }
}
