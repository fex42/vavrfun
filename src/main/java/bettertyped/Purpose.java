package bettertyped;

public final class Purpose {
    private final String value;

    private Purpose(final String purpose) {
        this.value = purpose;
    }

    public static Purpose of(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Purpose must not be null");
        }
        if (s.length() > 200) {
            throw new IllegalArgumentException("Purpose maximum length of 200 characters exceeded");
        }
        return new Purpose(s);
    }

    public String get() {
        return value;
    }
}
