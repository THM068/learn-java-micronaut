package learn.java.functions;

import java.util.function.Supplier;

public class RandonNumberSupplier implements Supplier<Double> {

    @Override
    public Double get() {
        return Math.random() * 10;
    }
}
