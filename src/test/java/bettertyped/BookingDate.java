package bettertyped;

import java.time.LocalDate;

public final class BookingDate {
    private final LocalDate value;

    private BookingDate(LocalDate localDate) {
        value = localDate;
    }

    /**
     * @param s  the text to parse such as "2007-12-03", not null
     * @return BookingDate
     */
    public static BookingDate of(final String s) {
        LocalDate localDate = LocalDate.parse(s);
        if (localDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("BookingDate is in the future!");
        }
        return new BookingDate(localDate);
    }

    public LocalDate get() {
        return value;
    }
}
