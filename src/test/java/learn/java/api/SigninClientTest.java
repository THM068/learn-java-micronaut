package learn.java.api;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MicronautTest;
import learn.java.api.model.ErrorCode;
import learn.java.api.model.SigninSuccessModel;
import learn.java.api.requests.SigninRequest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class SigninClientTest {

    @Inject
    SigninClient signinClient;


    @Test
    void signinToOOgway() {
        SigninRequest request = new SigninRequest("uzer", "test1234", "news",false);

        HttpResponse<SigninSuccessModel> response = signinClient.signin(request);

        assertEquals(201, response.status().getCode());
        SigninSuccessModel signinSuccessModel = response.body();
        System.out.println(signinSuccessModel);
        assertTrue(signinSuccessModel.getUsername().equalsIgnoreCase(request.getIdentifier()));
        assertTrue(signinSuccessModel.getToken().startsWith("00-"));
//        assertTrue(signinSuccessModel.getSecuretoken().startsWith("S0-"));
//        assertTrue(signinSuccessModel.getMessotoken().startsWith("01-"));
//        assertTrue(signinSuccessModel.getSecuremessotoken().startsWith("S1-"));
    }

    @Test
    void returns_error_code_from_wrong_credentials() {
        HttpResponse<SigninSuccessModel> response;
        SigninRequest request = new SigninRequest("uzer", "test123", "news",false);
        try {
            response = signinClient.signin(request);
            fail("Did not throw expected exception");
        }
        catch (HttpClientResponseException e) {
            Optional<ErrorCode> errorCodeOpt = e.getResponse().getBody(ErrorCode.class);
            if(errorCodeOpt.isPresent()) {
                ErrorCode errorCode = errorCodeOpt.get();
                assertTrue(errorCode.getMessage().contains("Invalid credentials:"));
                assertEquals("100",errorCode.getErrorcode());
            }
        }



    }

}
