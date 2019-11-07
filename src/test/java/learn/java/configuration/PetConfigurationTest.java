package learn.java.configuration;

import io.micronaut.context.annotation.Property;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
@Property(name="pets.name", value="Thomas")
public class PetConfigurationTest {

    @Inject
    private PetConfiguration petConfiguration;

    @Test
    void testPetconfiguration() {
        Assertions.assertEquals("Thomas", petConfiguration.getName());
    }
}
