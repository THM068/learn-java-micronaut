package learn.java.function;


import learn.java.functions.ConsumerExample;
import learn.java.functions.RandonNumberSupplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaFunctionsTest {

    @Test
    void predicateTest() {
        Predicate<String> predicate = (value) -> value.length() > 3;

        assertFalse(predicate.test("hel"));
        assertTrue(predicate.test("hello"));
    }

    @Test
    void supplierTest() {
        Supplier<Double> supplier = new RandonNumberSupplier();

        System.out.println(String.format("The random number is %f", supplier.get()));

        Supplier<String> stringSupplier = () -> "Hello World";
        assertEquals("Hello World", stringSupplier.get());
    }

    @Test
    void consumerTest() {
        Consumer<List<String>> listConsumer = new ConsumerExample();
        listConsumer.accept(Arrays.asList("Hello", "Thomas", "How are you?"));
    }

}
