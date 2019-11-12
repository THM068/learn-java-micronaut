package my.kafka.app;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExampleTest {

    @Test
    public void example1() {
        List<String> mylist = Arrays.asList("a1", "a2", "b1", "c1", "c2");

        mylist.stream()
              .filter( s -> s.startsWith("c"))
              .map(String::toUpperCase)
              .sorted()
              .collect(Collectors.toList());
    }


}

