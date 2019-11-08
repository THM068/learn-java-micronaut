package learn.java.aop;

import io.micronaut.context.annotation.Type;
import io.micronaut.aop.Around;
import java.lang.annotation.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Around
@Type(NotNullInterceptor.class)
public @interface NotNull {
}
