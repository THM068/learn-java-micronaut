package learn.java.api;

import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Headers;
import io.micronaut.http.client.annotation.Client;
import learn.java.api.model.ErrorCode;

@Client(value = "https://e05wap.oogway.bskyb.com", errorType = ErrorCode.class)
@Headers({
        @Header(name="Accept",value="application/vnd.oogway.v4+json"),
        @Header(name="Content-type",value="application/vnd.oogway.v4+json"),
        @Header(name="Authorization",value="Basic xxxxx"),
        @Header(name="Provider",value="SKY"),
        @Header(name="Territory",value="GB"),
})
public interface SigninClient  extends SigninOperations {
}
