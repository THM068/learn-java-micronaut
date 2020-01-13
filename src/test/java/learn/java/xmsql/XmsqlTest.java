package learn.java.xmsql;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.*;
import io.micronaut.test.annotation.MicronautTest;
import learn.java.IPerson;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;

import javax.inject.Inject;

@MicronautTest
public class XmsqlTest {

    @Rule
    public GenericContainer redis = new GenericContainer<>("redis:5.0.3-alpine")
            .withExposedPorts(6379);

    @Before
    void beforeSetup() {
        String address = redis.getContainerIpAddress();
        Integer port = redis.getFirstMappedPort();
        System.out.println("The port is "+ port);
    }

    @Inject
    ObjectMapper objectMapper;

    @Inject
    Schema database;

    @Test
    public void connectDatabase() throws JsonProcessingException {

        Collection person_collection = database.createCollection("person_collection", true);


        //person_collection.add("{\"name\":\"Thomas\", \"age\":1, \"sex\":\"male\"}").execute();
//        person_collection.add("{\"name\":\"Nadya\", \"age\":54}").execute();
//        person_collection.add("{\"name\":\"Lukas\", \"age\":32}").execute();

        //IPerson p = new IPerson("Kerrie", 33);
       // System.out.println(objectMapper.writeValueAsString(p));
       // person_collection.add(objectMapper.writeValueAsString(p)).execute();
        DocResult dbDocResult = person_collection.find("name like :name").bind("name", "Thomas").execute();

        System.out.println(dbDocResult.fetchOne().get("sex"));



    }
}
