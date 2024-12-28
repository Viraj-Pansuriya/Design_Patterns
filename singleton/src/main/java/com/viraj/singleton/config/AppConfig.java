package com.viraj.singleton.config;

import com.viraj.singleton.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Dog getDog() {
        return new Dog("husky", "1200");
    }
}
