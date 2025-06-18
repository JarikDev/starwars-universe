package cmd.starwars.universe.config;

import cmd.starwars.universe.services.mappers.EntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public EntityMapper getEntityMapper() {
        return Mappers.getMapper(EntityMapper.class);
    }

}
