package learn.java.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import learn.java.api.model.SigninSuccessModel;
import learn.java.api.requests.SigninRequest;

@Validated
public interface SigninOperations {

    @Post("/sessions")
    HttpResponse<SigninSuccessModel> signin(String identifier, String password, String servicename, boolean longlived);

}
