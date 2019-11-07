package learn.java.api;

import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Headers;
import io.micronaut.http.client.annotation.Client;
import learn.java.api.model.SigninSuccessModel;
import learn.java.api.requests.SigninRequest;

import io.micronaut.http.HttpResponse;

@Client(value = "https://e05wap.oogway.bskyb.com")
@Headers({
        @Header(name="Accept",value="application/vnd.oogway.v4+json, */*; q=0.01"),
        @Header(name="Content-type",value="application/vnd.oogway.v4+json"),
        @Header(name="Authorization",value="Basic b29nd2F5Om9vZ3dheTEyMw=="),
        @Header(name="Provider",value="SKY"),
        @Header(name="Territory",value="GB"),
})
public interface SigninClient  extends SigninOperations {
}
