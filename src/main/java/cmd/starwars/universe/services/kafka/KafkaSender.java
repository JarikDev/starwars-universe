package cmd.starwars.universe.services.kafka;

import cmd.starwars.universe.model.messages.ActionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaSender {


    private final KafkaTemplate<String, String> stringMsgKafka;
    private final KafkaTemplate<String, ActionMessage> actionMsgKafka;

    @Autowired
    public KafkaSender(KafkaTemplate<String, String> stringMsgKafka, KafkaTemplate<String, ActionMessage> actionMsgKafka) {
        this.stringMsgKafka = stringMsgKafka;
        this.actionMsgKafka = actionMsgKafka;
    }

    public void sendMessage(String msg, String topicName) {
        log.info("Sending string msg: {}", msg);
        stringMsgKafka.send(topicName, msg);
    }

    public void sendMessage(ActionMessage msg, String topicName) {
        log.info("Sending action msg: {}", msg);
        actionMsgKafka.send(topicName, msg);
    }
}