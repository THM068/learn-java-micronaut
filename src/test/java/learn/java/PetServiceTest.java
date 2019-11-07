package learn.java;

import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.ExecutableMethod;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@MicronautTest
public class PetServiceTest {

    @Inject
    ApplicationContext applicationContext;

    @Inject
    PetService petService;


   
    @Test
    void testExecutable() {
        ExecutableMethod<PetService, Object> em =
                applicationContext.getBeanDefinition(PetService.class).getRequiredMethod("listPets");

        List<String> result = (List<String>)em.invoke(petService);
        Assertions.assertEquals(3, result.size());
    }
}
