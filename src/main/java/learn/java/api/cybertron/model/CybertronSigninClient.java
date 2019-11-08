package learn.java.api.cybertron.model;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Headers;
import io.micronaut.http.client.annotation.Client;

@Client(value = "${app.url:https://f03agg.oogway.bskyb.com}", errorType = ErrorMessage.class)
@Headers( {
        @Header(name="Accept",value="application/vnd.bridge.v1+json"),
        @Header(name="Content-type",value="application/vnd.bridge.v1+json"),
        @Header(name="Authorization",value="Basic cmFuZ29fYnJpZGdlOnJhbmdv"),
        @Header(name="X-SkyOTT-Proposition",value="SKY"),
        @Header(name="X-SkyOTT-Provider",value="SKY"),
        @Header(name="X-SkyOTT-Territory",value="GB")
})
public interface CybertronSigninClient extends CybertronSigninOperations {
}
