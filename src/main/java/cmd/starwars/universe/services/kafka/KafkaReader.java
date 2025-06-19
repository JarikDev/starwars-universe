package cmd.starwars.universe.services.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaReader {

    @KafkaListener(topics = "${spring.kafka.topics.testTopic}", groupId = "group1")
    void testTopicListener(String data) {
        log.info("Received message [{}] in testTopic", data);
    }

    @KafkaListener(topics = "${spring.kafka.topics.creationTopic}", groupId = "group1")
    void creationTopicListener(String data) {
        log.info("Received message [{}] in creationTopic", data);
    }

    @KafkaListener(topics = "${spring.kafka.topics.destructionTopic}", groupId = "group1")
    void destructionTopicListener(String data) {
        log.info("Received message [{}] in destructionTopic", data);
    }
}