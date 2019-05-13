package functional;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Optional;

public class NullPointerHorror {
    @Data
    @AllArgsConstructor
    class Customer {
        private Integer id;
        private String name;

    }

    interface CustomerRepository {
        Customer getCustomer(Integer id);
    }

    class CustomerRepositoryImpl implements CustomerRepository {

        @Override
        public Customer getCustomer(Integer id) {
            if (id.equals(42)) {
                return new Customer(42, "Max");
            }
            return null;
        }
    }

    @Test
    public void theProblemWithNull() {
        CustomerRepository repository = new CustomerRepositoryImpl();

        Customer cust = repository.getCustomer(99);

        System.out.println(cust.getName());
    }

    // safe alternative with Optional:

    interface SafeCustomerRepository {
        Optional<Customer> getCustomer(Integer id);
    }

    class SafeCustomerRepositoryImpl implements SafeCustomerRepository {

        @Override
        public Optional<Customer> getCustomer(Integer id) {
            if (id.equals(42)) {
                return Optional.of(new Customer(42, "Max"));
            }
            return Optional.empty();
        }
    }

    @Test
    public void avoidTheNullProblemWithOptional() {
        SafeCustomerRepository repository = new SafeCustomerRepositoryImpl();

        Optional<Customer> cust = repository.getCustomer(99);

        System.out.println(cust.orElse(new Customer(-1, "Does Not Exist")));
    }

}
