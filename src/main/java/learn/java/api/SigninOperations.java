package learn.java.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.validation.Validated;
import learn.java.api.model.SigninSuccessModel;
import learn.java.api.requests.SigninRequest;

@Validated
public interface SigninOperations {

    @Post("/sessions")
    @Produces(value = "application/vnd.oogway.v4+json")
    @Consumes(value = "application/vnd.oogway.v4+json")
    HttpResponse<SigninSuccessModel> signin(@Body SigninRequest request);

}
