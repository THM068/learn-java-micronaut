package learn.java;

import io.micronaut.context.annotation.Executable;
import io.micronaut.context.annotation.Requires;

import java.util.Arrays;
import java.util.List;

public class PetService implements IPetService{

    @Override
    @Executable
    public List<String> listPets() {
        return Arrays.asList("Iguana", "Wombat", "Emu");
    }
}
