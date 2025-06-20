package cmd.starwars.universe.services.kafka;

import cmd.starwars.universe.model.messages.ActionMessage;
import cmd.starwars.universe.services.kafka.handlers.ActionMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaReader {
    private final ActionMessageHandler handler;

    @Autowired
    public KafkaReader(ActionMessageHandler handler) {
        this.handler = handler;
    }

    @KafkaListener(topics = "${spring.kafka.topics.testTopic}",
            groupId = "${spring.kafka.groupId}",
            containerFactory = "stringListenerFactory")
    void testTopicListener(String msg) {
        log.info("Received message [{}] in testTopic", msg);
    }

    @KafkaListener(topics = "${spring.kafka.topics.creationTopic}",
            groupId = "${spring.kafka.groupId}",
            containerFactory = "stringListenerFactory")
    void creationTopicListener(String msg) {
        log.info("Received message [{}] in creationTopic", msg);
    }

    @KafkaListener(topics = "${spring.kafka.topics.destructionTopic}",
            groupId = "${spring.kafka.groupId}",
            containerFactory = "stringListenerFactory")
    void destructionTopicListener(String msg) {
        log.info("Received message [{}] in destructionTopic", msg);
    }

    @KafkaListener(topics = "${spring.kafka.topics.actionTopic}",
            groupId = "${spring.kafka.groupId}",
            containerFactory = "actionListenerFactory")
    void actionTopicListener(ActionMessage msg) {
        log.info("Received message [{}] in actionTopic", msg);

        try {
            handler.handle(msg);
        } catch (Exception e) {
            log.error("error handling action msg {}", e.getMessage());
        }
    }
}