package learn.java.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.test.annotation.MicronautTest;
import learn.java.api.model.SigninSuccessModel;
import learn.java.api.requests.SigninRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
public class SigninClientTest {

    @Inject
    SigninClient signinClient;

    @Test
    void signinToOOgway() {
        SigninRequest request = new SigninRequest("uzer", "test1234", "news",false);

        HttpResponse<SigninSuccessModel> response = signinClient.signin("uzer", "test1234", "news",false);

        assertEquals(201, response.status().getCode());
        SigninSuccessModel signinSuccessModel = response.body();
        System.out.println(response.getBody(String.class).orElse("null"));
        System.out.println(signinSuccessModel);
//        assertTrue(signinSuccessModel.getUsername().equalsIgnoreCase(request.getIdentifier()));
//        assertTrue(signinSuccessModel.getToken().startsWith("00-"));
//        assertTrue(signinSuccessModel.getSecuretoken().startsWith("S0-"));
//        assertTrue(signinSuccessModel.getMessotoken().startsWith("01-"));
//        assertTrue(signinSuccessModel.getSecuremessotoken().startsWith("S1-"));
    }

}
