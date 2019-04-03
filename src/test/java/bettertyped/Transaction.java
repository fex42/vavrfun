package bettertyped;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Optional;

@Builder
@Value
public final class Transaction {
    private final BookingDate bookingDate;
    private final MoneyAmount amount;
    private final Purpose purpose;
    private final Iban counterpartIban;
    private final Optional<Bic> counterpartBic;
}

