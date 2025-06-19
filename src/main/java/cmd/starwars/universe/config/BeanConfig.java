package cmd.starwars.universe.config;

import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.data.EntityService;
import cmd.starwars.universe.services.data.EntityServiceImpl;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

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
    public ProducerFactory<String, String> producerFactory() {
        String bootstrapAddress = "localhost:9094";
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
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
}
