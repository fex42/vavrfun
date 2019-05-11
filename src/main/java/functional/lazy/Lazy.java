package functional.lazy;

import io.vavr.Function0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class Lazy {
    public static String loadContents() {
        final long id = System.nanoTime() % 1000;
        System.out.println("### loading contents from file (" + id + ") ###");
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Contents #" + id;
    }

    public static <T> Supplier<T> memoizeSupplier(final Supplier<T> s) {
        final Map<Long,T> lazy = new ConcurrentHashMap<>();
        return () -> lazy.computeIfAbsent(1L, i-> s.get());
    }


    public static void main(String[] args) {
        System.out.println("\nlazy without caching:");
        Supplier<String> contentSupplier = Lazy::loadContents;
        System.out.println("Call #1: " + contentSupplier.get());
        System.out.println("Call #2: " + contentSupplier.get());
        System.out.println("Call #3: " + contentSupplier.get());

        System.out.println("\nlazy with caching:");
        Supplier<String> memoizeContentsSupplier = memoizeSupplier(Lazy::loadContents);
        System.out.println("Call #1: " + memoizeContentsSupplier.get());
        System.out.println("Call #2: " + memoizeContentsSupplier.get());
        System.out.println("Call #3: " + memoizeContentsSupplier.get());

        System.out.println("\nlazy with caching (VAVR):");
        Function0 vavrMemoized = Function0.of(Lazy::loadContents).memoized();
        System.out.println("Call #1: " + vavrMemoized.get());
        System.out.println("Call #2: " + vavrMemoized.get());
        System.out.println("Call #3: " + vavrMemoized.get());
    }
}
