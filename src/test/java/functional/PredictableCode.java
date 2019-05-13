package functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class PredictableCode {
    @Data
    @AllArgsConstructor
    class Order {
        private Integer id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    class Transaction {
        private Integer id;
        private String name;
    }

    @Test
    public void equalChecks() {
        String s1 = "Foo";
        String s2 = "Foo";
        boolean equalStrings = s1 == s2;

        Order order1 = new Order(99, "Sepp");
        Order order2 = new Order(99, "Sepp");
        boolean equalCustomers = order1 == order2;

        Assertions.assertThat(equalStrings).isEqualTo(equalCustomers);
    }


    @Test
    public void mutableObjectsInHashSet() {
        Order order = new Order(99, "Sepp");

        java.util.Set<Order> customers = new HashSet<>();
        customers.add(order);

        doSth(order);

        boolean cust1inSet = customers.contains(order);

        Assertions.assertThat(customers.contains(order)).isTrue();
    }

    private void doSth(Order cust) {
        cust.setName(cust.getName() + "X");
    }

    @Test
    public void equalityOfDifferentClasses() {
        Transaction trans = new Transaction(99, "Sepp");
        Order order = new Order(99, "Sepp");

        boolean isEqual = trans.equals(order); // This is a bug!!!

        Assertions.assertThat(isEqual).isFalse();
    }
}
