package learn.java.api.cybertron.model;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import org.reactivestreams.Publisher;

@Filter(value = {"/sessions"})
public class CybertronSigninClientFilter implements HttpClientFilter {
    private String username;
    private String password;

    public CybertronSigninClientFilter(@Value("${cybertron.username}") String username, @Value("${cybertron.password}")String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain) {
        return chain.proceed(request.basicAuth(this.username, this.password));
    }
}
