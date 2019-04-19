package bettertyped;

import java.math.BigDecimal;

public final class MoneyAmount {
    private final BigDecimal value;

    private MoneyAmount(BigDecimal value){
        this.value = value;
    }

    public static MoneyAmount of(String s) {
        return of(new BigDecimal(s));
    }

    public static MoneyAmount of(BigDecimal s) {
        if (s == null) {
            throw new NullPointerException("MoneyAmount must not be null");
        }
        if (s.scale() > 4) {
            throw new IllegalArgumentException("MoneyAmount precision must not exceet 4 digits");
        }
        if (s.compareTo(BigDecimal.valueOf(1_000_000_000_000_000_000L)) > 0) {
            throw new IllegalArgumentException("MoneyAmount too large");
        }
        if (s.compareTo(BigDecimal.valueOf(-1_000_000_000_000_000_000L)) > 0) {
            throw new IllegalArgumentException("MoneyAmount too small");
        }
        return new MoneyAmount(s);
    }

    public BigDecimal get() {
        return value;
    }
}
