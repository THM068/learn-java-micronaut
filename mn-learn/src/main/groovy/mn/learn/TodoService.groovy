package mn.learn

import groovy.transform.CompileStatic
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Singleton
import javax.inject.Inject

@javax.inject.Singleton
class TodoService {

    @Client(value = "https://jsonplaceholder.typicode.com")
    @Inject RxHttpClient client;

    Flowable<String> getTodo(int id) {
        String uri = UriBuilder.of("/todos/{id}").expand(Collections.singletonMap("id",1)).toString()
        client.retrieve(uri)
    }
}
