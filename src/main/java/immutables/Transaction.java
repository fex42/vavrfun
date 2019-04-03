package immutables;

import bettertyped.*;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public abstract class Transaction {
    public abstract BookingDate bookingDate();
    public abstract MoneyAmount amount();
    public abstract Purpose purpose();
    public abstract Iban counterpartIban();
    public abstract Optional<Bic> counterpartBic();
}
