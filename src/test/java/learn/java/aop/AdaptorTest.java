package learn.java.aop;

import io.micronaut.test.annotation.MicronautTest;
import learn.java.aop.adaptor.MyProcessor;
import learn.java.aop.adaptor.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class AdaptorTest {

    @Inject
    List<MyProcessor> myProcessors;

    @Test
    void test_myprocessor() {
        assertEquals(2, myProcessors.size());
        myProcessors.forEach( myProcessor -> {
            myProcessor.call(new Pet("doxy"));
        });
    }
}
