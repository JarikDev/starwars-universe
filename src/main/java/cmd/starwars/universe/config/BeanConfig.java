package cmd.starwars.universe.config;

import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.data.EntityService;
import cmd.starwars.universe.services.data.EntityServiceImpl;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class BeanConfig {

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


//    @Bean
//    public ConsumerFactory<String, ActionMessage> actionMessageConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProps.getBootstrapServers());
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProps.getGroupId());
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "cmd.starwars.universe.model.messages");
//        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ActionMessage.class.getName());
//
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, ActionMessage> actionMessageKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, ActionMessage> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(actionMessageConsumerFactory());
//        return factory;
//    }
//
//
//    @Bean
//    public ConsumerFactory<String, String> stringConsumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProps.getBootstrapServers());
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProps.getGroupId());
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
////        props.put(JsonDeserializer.TRUSTED_PACKAGES, "cmd.starwars.universe.model.messages");
////        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, String.class.getName());
//
//        return new DefaultKafkaConsumerFactory<>(props);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> stringKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(stringConsumerFactory());
//        return factory;
//    }
}
