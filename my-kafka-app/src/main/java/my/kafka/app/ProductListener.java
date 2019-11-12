package my.kafka.app;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import org.apache.kafka.clients.consumer.ConsumerRecord;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class ProductListener {

    @Topic("test")
    public void receive(ConsumerRecord<String, Product> record) {
        System.out.println("Got Product - " + record.value().getName() + " by " + record.key());
    }
}
