package bettertyped;

import org.junit.Test;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class BetterTyped {

    @Test
    public void unsafeStringTypeConfusion() {
        // typesafe constructor parameters reduce risk of errors
        Transaction t1 = new Transaction(BookingDate.of("2019-04-05"), MoneyAmount.of("1234.50"),
                Purpose.of("Verwendungszweck"), Iban.of("DE89370400440532013000"),
                Optional.of(Bic.of("COBADEFFXXX ")));

        Transaction t2 = Transaction.builder()
                .bookingDate(BookingDate.of("2019-04-05"))
                .amount(MoneyAmount.of("1234.50"))
                .purpose(Purpose.of("Verwendungszweck"))
                .counterpartIban(Iban.of("DE89370400440532013000"))
                .counterpartBic(Optional.of(Bic.of("COBADEFFXXX ")))
                .build();

        LocalDate bookingDate = t1.getBookingDate().get();
        BigDecimal amount = t1.getAmount().get();
        String purpose = t1.getPurpose().get();
        String iban = t1.getCounterpartIban().get();
        Optional<Bic> optionalBic = t1.getCounterpartBic();
        if (optionalBic.isPresent()) {
            String bic = optionalBic.get().get();
        } else {
            // can't forget to handle case where BIC is not present
        }
    }
}
