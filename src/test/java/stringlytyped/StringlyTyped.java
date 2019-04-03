package stringlytyped;

import org.junit.Test;

import java.math.BigDecimal;

public class StringlyTyped {

    @Test
    public void unsafeStringTypeConfusion() {
        // high risk to swap two string parameters in your code, compiler won't complain
        Transaction t1 = new Transaction("", BigDecimal.ONE, "", "", "");

        Transaction t2 = Transaction.builder()
                .bookingDate("2019-04-05")
                .amount(new BigDecimal("1234.50"))
                .purpose("Verwendungszweck")
                .counterpartIban("DE89370400440532013000")
                .counterpartBic("COBADEFFXXX ")
                .build();

        String bookingDate = t1.getBookingDate();
        BigDecimal amount = t1.getAmount();
        String purpose = t1.getPurpose();
        String iban = t1.getCounterpartIban();
        String bic = t1.getCounterpartBic(); // risk that you forget to handle null value
    }
}
