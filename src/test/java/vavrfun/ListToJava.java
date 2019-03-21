package vavrfun;

import io.vavr.collection.Iterator;
import io.vavr.collection.List;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListToJava {

    @Test
    public void vavrCollectionToJavaList() {
        List<String> vavrList = List.of("foo", "bar", "DingensKirchens", "x", "Blafasl");

        // Vavr and Java are fully interoperable
        java.util.List<Integer> javaList = vavrList.map(String::length).asJava();

        assertThat(javaList.size()).isEqualTo(vavrList.size());
    }
}
