package learn.java.api.cybertron.model;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MicronautTest;
import learn.java.api.model.SigninSuccessModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
public class CybertronClientTest {

    @Inject
    CybertronSigninClient cybertronSigninClient;
    @BeforeEach
    void setup() {

    }

    @Test
    @Property(name = "app.url", value = "https://f02agg.oogway.bskyb.com")
    void a_user_can_signin() {

        SigninPayload payload = new SigninPayload("thomasKhulani@example.com", "test1234", true);

        try {
            HttpResponse<SigninSuccessModel> response = cybertronSigninClient.signin(payload);

            assertEquals(201, response.status().getCode());
            SigninSuccessModel signinSuccessModel = response.body();
            System.out.println(signinSuccessModel);
            assertTrue(signinSuccessModel.getUsername().equalsIgnoreCase("THOMASKHULANI"));
            assertTrue(signinSuccessModel.getToken().startsWith("00-"));
            assertTrue(signinSuccessModel.getSecuretoken().startsWith("S0-"));
            assertTrue(signinSuccessModel.getMessotoken().startsWith("01-"));
            assertTrue(signinSuccessModel.getSecuremessotoken().startsWith("S1-"));
        }
        catch(HttpClientResponseException e) {
            Optional<ErrorMessage> errorMessageOpt = e.getResponse().getBody(ErrorMessage.class);
            if(errorMessageOpt.isPresent()) {
                ErrorMessage errorCode = errorMessageOpt.get();
                System.out.println(errorCode.getMessage());
                System.out.println(errorCode.getErrorcode());
                System.out.println(errorCode.getService());
            }
            fail("Cybertron client failed to siginin");
        }


    }
}
