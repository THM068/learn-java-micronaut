package learn.java.aop;

import io.micronaut.context.ApplicationContext;
import io.micronaut.test.annotation.MicronautTest;
import learn.java.Application;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
@MicronautTest
public class NotNullExampleTest {

    @Inject
    NotNullExample exampleBean;

    @Test
    public void testNull() {

        try {
            exampleBean.doWork(null);
            fail("Exception has not been thrown");
        }
        catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Null parameter [taskName] not allowed"));
        }
    }

}
