package learn.java;

import io.micronaut.context.annotation.Executable;
import io.micronaut.context.annotation.Requires;
import io.micronaut.runtime.event.annotation.EventListener;
import learn.java.aop.adaptor.Pet;
import learn.java.aop.adaptor.Processed;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

@Singleton
public class PetService implements IPetService{

    @Override
    @Executable
    public List<String> listPets() {
        return Arrays.asList("Iguana", "Wombat", "Emu");
    }

    @Processed
    public void someMethod(Pet p) {
        System.out.println("Pet = " + p);
    }

    @Processed
    @EventListener
    public void anotherMethod(Pet p) {
        System.out.println("Pet = " + p);
    }


}
