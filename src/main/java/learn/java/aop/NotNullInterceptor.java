package learn.java.aop;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.type.MutableArgumentValue;

import javax.inject.Singleton;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
@Singleton
public class NotNullInterceptor implements MethodInterceptor<Object, Object> {

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        Optional<Map.Entry<String, MutableArgumentValue<?>>> nullParam = context.getParameters()
                .entrySet()
                .stream()
                .filter( entry -> {
                    MutableArgumentValue<?> argumentValue = entry.getValue();
                    return Objects.isNull(argumentValue.getValue());
                }).findFirst();
        if(nullParam.isPresent()) {
            throw new IllegalArgumentException("Null parameter [" + nullParam.get().getKey() + "] not allowed");
        }
        else {
            return context.proceed();
        }
    }
}
