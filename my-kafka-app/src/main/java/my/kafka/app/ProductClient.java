package my.kafka.app;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.Body;

@KafkaClient
public interface ProductClient {

    @Topic("test")
    void sendProduct(@KafkaKey String brand,  Product product);

    void sendProduct(@Topic String topic, @KafkaKey String brand, String name);
}


