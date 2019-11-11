package learn.java.aop.adaptor;

import io.micronaut.aop.Adapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Adapter(MyProcessor.class)
@Retention(RUNTIME)
@Target({ElementType.METHOD})
public @interface Processed {
}
