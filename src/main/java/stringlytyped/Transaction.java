package stringlytyped;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Transaction {
    private final String bookingDate; // format yyyy-mm-dd
    private final BigDecimal amount;
    private final String purpose;
    private final String counterpartIban;
    private final String counterpartBic; // not required
}

