package functional.immutability;

public class ImmutableDemo {
    public static void main(String[] args) {
        final LombokImmutableRGB black = new LombokImmutableRGB(0,0,0);
        final LombokImmutableRGB white = new LombokImmutableRGB(255,255,255);

        System.out.println("black = " + black);
        System.out.println("white = " + white);

        LombokImmutableRGB blue = black.withBlue(255);
        System.out.println("blue = "+ blue);

        KotlinRGB ktBlack = new KotlinRGB(0,0,0);
        System.out.println("Kotlin black = " + ktBlack);
    }
}
