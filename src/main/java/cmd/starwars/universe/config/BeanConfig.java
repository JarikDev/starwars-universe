package cmd.starwars.universe.config;

import cmd.starwars.universe.model.messages.ActionMessage;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.data.EntityService;
import cmd.starwars.universe.services.data.EntityServiceImpl;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanConfig {
    @Autowired
    private TopicsConfig topics;

    @Bean
    public EntityMapper getEntityMapper() {
        return Mappers.getMapper(EntityMapper.class);
    }

    @Bean
    public EntityService<Allegiance> getAllegianceEntityService(JpaRepository<Allegiance, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Hero> getHeroEntityService(JpaRepository<Hero, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Planet> getPlanetEntityService(JpaRepository<Planet, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<ShipClass> getShipClassEntityService(JpaRepository<ShipClass, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Ship> getShipEntityService(JpaRepository<Ship, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<StarSystem> getStarSystemEntityService(JpaRepository<StarSystem, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Unit> getTrooperEntityService(JpaRepository<Unit, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public ProducerFactory<String, String> stringMsgProducerFactory() {
        String bootstrapAddress = "localhost:9094";
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public ProducerFactory<String, ActionMessage> actionMsgProducerFactory() {
        String bootstrapAddress = "localhost:9094";
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> stringMsgKafka(ProducerFactory<String, String> pf) {
        return new KafkaTemplate<>(pf);
    }

    @Bean
    public KafkaTemplate<String, ActionMessage> actionMsgKafka(ProducerFactory<String, ActionMessage> pf) {
        return new KafkaTemplate<>(pf);
    }

    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name(topics.getTestTopic()).build();
    }

    @Bean
    public NewTopic creationTopic() {
        return TopicBuilder.name(topics.getCreationTopic()).build();
    }

    @Bean
    public NewTopic destructionTopic() {
        return TopicBuilder.name(topics.getDestructionTopic()).build();
    }

    @Bean
    public ConsumerFactory<String, ActionMessage> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9094");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "star_wars_universe_listener");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "cmd.starwars.universe.model.messages");
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ActionMessage.class.getName());

        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ActionMessage> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ActionMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

//    @Bean
//    public ConsumerFactory<String, ActionMessage> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("group.id", "star_wars_universe_listener");
//        props.put("key.deserializer", StringDeserializer.class.getName());
//        props.put("value.deserializer", StringDeserializer.class.getName());
//
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new StringDeserializer());
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, ActionMessage> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, ActionMessage> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        factory.setMessageConverter(new JsonMessageConverter());
//        return factory;
//    }
}
