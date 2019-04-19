package bettertyped;

public final class Iban {
    private final String value;

    private Iban(String value) {
        this.value = value;
    }

    public static Iban of(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Iban must not be null");
        }
        if (s.length() > 34) {
            throw new IllegalArgumentException("Iban maximum length of 34 characters exceeded");
        }
        if (s.length() < 15) {
            throw new IllegalArgumentException("Iban minimum length of 15 characters deceed");
        }
        if (!Character.isAlphabetic(s.charAt(0)) || !Character.isAlphabetic(s.charAt(1))) {
            throw new IllegalArgumentException("Iban first two letters must be alphas");
        }
        return new Iban(s);
    }

    public String get() {
        return value;
    }
}
