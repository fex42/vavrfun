package functional.immutability;

import java.util.Objects;

public final class ImmutableRGB {
    private final int red;
    private final int green;
    private final int blue;

    public ImmutableRGB(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableRGB)) return false;
        ImmutableRGB that = (ImmutableRGB) o;
        return red == that.red &&
                green == that.green &&
                blue == that.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    @Override
    public String toString() {
        return "ImmutableRGB{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
