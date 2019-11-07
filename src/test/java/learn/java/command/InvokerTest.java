package learn.java.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvokerTest {
    private Invoker invoker;
    private Light light = new Light();
    private LightOffCommand lightOffCommand = new LightOffCommand(light);
    private LightOnCommand lightOnCommand = new LightOnCommand(light);

    @BeforeEach
    void setup() {
        invoker = new Invoker();
    }

    @Test
    void test_light_off() {
        invoker.setCommand(lightOffCommand);
        invoker.startCommand();
        invoker.undo();
    }
}
