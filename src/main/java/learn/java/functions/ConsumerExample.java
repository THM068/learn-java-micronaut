package learn.java.functions;

import java.util.List;
import java.util.function.Consumer;

import static java.lang.String.*;

public class ConsumerExample implements Consumer<List<String>> {

    @Override
    public void accept(List<String> strings) {
        strings.forEach( (value) -> {
            System.out.println(format("The value is %s", value));
        });
    }
}
