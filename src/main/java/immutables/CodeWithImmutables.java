package immutables;

import bettertyped.*;

import java.util.Optional;

public class CodeWithImmutables {
    Transaction t1 = immutables.ImmutableTransaction.builder()
            .bookingDate(BookingDate.of("2019-04-05"))
            .amount(MoneyAmount.of("1234.50"))
            .purpose(Purpose.of("Verwendungszweck"))
            .counterpartIban(Iban.of("DE89370400440532013000"))
            .counterpartBic(Optional.of(Bic.of("COBADEFFXXX ")))
            .build();
}
