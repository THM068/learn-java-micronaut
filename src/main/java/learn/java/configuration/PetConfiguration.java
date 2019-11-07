package learn.java.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties(value = "pets")
public class PetConfiguration {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
