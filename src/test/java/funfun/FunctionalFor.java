package funfun;

import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static io.vavr.API.*;
import static io.vavr.Patterns.$None;
import static io.vavr.Patterns.$Some;

public class FunctionalFor {

    @Data
    @AllArgsConstructor
    class Address {
        private String street;
    }

    @Data
    @AllArgsConstructor
    class Person {
        private String name;
        private Integer age;
        private List<Address> addresses;

        public boolean hasAddress() {
            return addresses.hasDefiniteSize();
        }
    }

    private final List<Person> persons = List.of(new Person("Felix", 42, List.of(new Address("Hauptstr. 23")))
            , new Person("Artur", 37, List.of(new Address("Wiesenweg 42"), new Address("Holzacker 3")))
            , new Person("Maxi", 14, List.of(new Address("Hauptmarkt 1")))
            , new Person("Hans", 39, List.of(new Address("Sonnenplatz 7")))
            , new Person("Sepp", 25, List.of(new Address("Waldweg 31"), new Address("Zweitstraße 13")))
            , new Person("Max", 16, List.of(new Address("Maxstr 12")))
    );

    @Test
    public void functionalFor() {


        // The functional For is an expression that yields a value.
        // The result is a lazy evaluated collection of elements.

        Iterator<String> iterator =
                For(persons.filter(Person::hasAddress), p ->
                        For(p.addresses).yield(a ->
                                p.name + ", " + a.street
                        )
                );

        for (String s : iterator) {
            System.out.println(s);
        }
    }

    @Test
    public void filterAdults() {
        List<String> adultNames = persons.filter(p -> p.age >= 18).map(Person::getName);

        System.out.println(adultNames);
    }

    @Test
    public void patternMatch() {

        Option<Person> personOption = Option.none();

        Number num = Match(personOption).of(
                Case($Some($()), person -> 1.0d),
                Case($None(), 0)
        );

        Assertions.assertThat(num).isEqualTo(0);

        Option<Person> personOption2 = Option.some(new Person("Felix", 42, List()));

        Number num2 = Match(personOption2).of(
                Case($Some($()), person -> 1.0d),
                Case($None(), 0)
        );

        Assertions.assertThat(num2).isEqualTo(1.0d);
    }
}
