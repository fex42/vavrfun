package functional;

import io.vavr.collection.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ListToJava {

    @Test
    public void vavrCollectionToJavaList() {
        List<String> vavrList = List.of("foo", "bar", "DingensKirchens", "x", "Blafasl");

        // Vavr and Java are fully interoperable
        java.util.List<Integer> javaList = vavrList.map(String::length).asJava();

        Assertions.assertThat(javaList.size()).isEqualTo(vavrList.size());
    }

}
