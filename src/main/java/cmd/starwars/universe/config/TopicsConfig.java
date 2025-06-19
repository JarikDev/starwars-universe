package cmd.starwars.universe.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka.topics")
@Getter
@Setter
public class TopicsConfig {
    private String testTopic;
    private String creationTopic;
    private String destructionTopic;
    private String actionTopic;
}
