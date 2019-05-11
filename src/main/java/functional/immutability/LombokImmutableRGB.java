package functional.immutability;

import lombok.Value;
import lombok.experimental.Wither;

@Value
public class LombokImmutableRGB {
    @Wither
    private final int red;
    @Wither
    private final int green;
    @Wither
    private final int blue;
}
