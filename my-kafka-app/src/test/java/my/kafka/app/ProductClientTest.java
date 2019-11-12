package my.kafka.app;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Arrays;

@MicronautTest
public class ProductClientTest {

    @Inject
    ProductClient productClient;


    @Test
    public void testClient() {
        Arrays.asList("a","b","c").forEach( a -> productClient.sendProduct("Nike", new Product(a)));


    }

}
