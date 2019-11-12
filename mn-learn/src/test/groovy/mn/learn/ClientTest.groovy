package mn.learn

import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import io.micronaut.test.annotation.MicronautTest
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import io.reactivex.subscribers.DisposableSubscriber
import spock.lang.Specification

import javax.inject.Inject
import java.util.function.Consumer

@MicronautTest
class ClientTest extends Specification {


    @Inject TodoService todoService;

    def 'test todo'() {
        when:
            Flowable<String> uri = todoService.getTodo(1)
        then:
            Maybe<String> result = uri.firstElement()
//            println(result.blockingGet())
            result.subscribe( { s -> println(s)})

    }

    def 'rxjava test subscribe'() {
        when:
             //Observable.fromIterable(['a','b','c']).subscribe({ i -> println i})
             Observable.fromIterable(['a','b','c']).subscribeWith(new TestMe())

        then:
            true
    }

}

class TestMe extends DisposableObserver<String> {

    @Override
    void onNext(String s) {
        println s
    }

    @Override
    void onError(Throwable t) {

    }

    @Override
    void onComplete() {
        println "complete"
    }
}
