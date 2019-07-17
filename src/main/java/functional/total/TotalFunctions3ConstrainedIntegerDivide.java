package functional.total;

public class TotalFunctions3ConstrainedIntegerDivide {
    public static void main(String[] args) {
        TotalFunctions3ConstrainedIntegerDivide app = new TotalFunctions3ConstrainedIntegerDivide();
        app.run();
    }

    static final class Not0Integer {
        private final int value;

        private Not0Integer(int value) {
            if (value == 0) {
                throw new IllegalArgumentException("0 is not allowed");
            }
            this.value = value;
        }

        public int value() {
            return value;
        }

        public static Not0Integer of(int value) {
            return new Not0Integer(value);
        }
    }

    public Integer divide(Integer dividend, Not0Integer divisor) {
        return dividend / divisor.value();
    }

    private void run() {
        System.out.println("10 / 2 = " + divide(10, Not0Integer.of(2)));
        System.out.println("9 / 2 = " + divide(9, Not0Integer.of(2)));
        System.out.println("9 / 0 = " + divide(9, Not0Integer.of(0)));
    }
}
