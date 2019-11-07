package learn.java.api.cybertron.model;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import learn.java.api.model.SigninSuccessModel;

public interface CybertronSigninOperations {

    @Post("/sessions")
    @Produces(value = "application/vnd.bridge.v1+json")
    @Consumes(value = "application/vnd.bridge.v1+json")
    HttpResponse<SigninSuccessModel> signin(@Body SigninPayload request);
}
