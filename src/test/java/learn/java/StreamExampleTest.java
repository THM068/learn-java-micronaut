package learn.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.lang.System.*;
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

    @Test
    void examples() {
        Arrays.asList("a1", "a2", "a3")
              .stream()
              .findFirst()
              .ifPresent(System.out::println);

        IntStream.range(0, 20)
                 .map( a -> a * 2)
                 .forEach(System.out::println);
        System.out.println("-----");

        IntStream.range(1, 14)
                 .map( n -> 2 * n + 1)
                 .average()
                 .ifPresent(System.out::println);

        Stream.of(1.0, 2.0, 3.0)
              .mapToInt(Double::intValue)
              .mapToObj( i -> "a" + 1)
              .forEach(System.out::println);
        System.out.println("-----");

        Stream.of("d2", "a1", "q2")
              .filter( s -> {
                  System.out.println("filter: " + s);
                  return true;
              })
              .forEach( s -> System.out.println("foreach: "+ s ));
        System.out.println("-----");

        Stream.of("d2", "a2", "b1", "b3", "c")
              .map( s ->  {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
              })
              .anyMatch( s -> {
                  System.out.println("anyMatch: " + s);
                  return s.startsWith("A");
              });

        System.out.println("-----|");
        Stream.of("d2", "a2", "b1", "b3", "c")
              .sorted( (s1, s2) -> {
                  System.out.printf("sort: %s %s\n", s1, s2);
                  return s1.compareTo(s2);
              })
              .filter( s -> {
                  System.out.println("filter: " + s);
                  return s.startsWith("a");
              })
              .map( s -> {
                  System.out.println("map: " + s);
                  return s.toUpperCase();
              })
              .forEach( s -> System.out.println( "foreach: " + s));

    }

    @Test
    void streamFromSupplier() {
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter( s -> s.startsWith("a"));

        assertTrue(streamSupplier.get().anyMatch( s -> true));

        assertFalse(streamSupplier.get().noneMatch( s -> true));
    }

    @Test
    void collectorTests() {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

        List<Person> filtered = persons.stream()
                                       .filter( p -> p.name.startsWith("P") )
                                       .collect(Collectors.toList());
        System.out.println(filtered);
    }

    @Test
    void groupByAge() {
        Map<Integer, List<Person>> personByAge = personList().stream()
                                                             .collect(Collectors.groupingBy( p -> p.age));

        personByAge.forEach((age, p) -> System.out.printf("age %s: %s\n", age, p));
    }

    @Test
    void ageSummary() {
        IntSummaryStatistics ageSummary = personList().stream()
                                                        .collect(Collectors.summarizingInt( p -> p.age));

        out.println(ageSummary);

        String phrase = personList().stream()
                                    .filter( p -> p.age >= 18)
                                    .map( p -> p.name)
                                    .collect(Collectors.joining(" and ", " In Germany ", " are of legal age."));
        out.println(phrase);


    }

    @Test
    void stringJoiner() {
        StringJoiner joiner = new StringJoiner(":");
        joiner.add("Hello").add("world").add("mister");
        out.println(joiner.toString());
    }

    private List<Person> personList() {
        return Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));
    }
}

 class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}