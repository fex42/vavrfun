package bettertyped;

public final class Bic {
    private String value;

    private Bic(String value) {
        this.value = value;
    }

    public static Bic of(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Bic must not be null");
        }
        if (s.length() != 8 && s.length() != 11) {
            throw new IllegalArgumentException("Bic must be 8 or 11 characters long");
        }
        return new Bic(s);
    }

    public String get() {
        return value;
    }
}
