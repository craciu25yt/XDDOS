package de.xddosapi;

import de.xddosapi.content.AuthProperties;
import de.xddosapi.utils.enums.Properties;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Getter
public class XddosApi {

    private static XddosApi instance;

    private AuthProperties authProperties;

    public static void main(final String[] args) throws IOException {
        instance = new XddosApi();
        instance.authProperties = new AuthProperties();

        final SpringApplication springApplication = new SpringApplication(XddosApi.class);
        final Map<String, Object> properties = new HashMap<>();
        final java.util.Properties values = instance.authProperties.getProperties();

        properties.put(Properties.SPRING_DATASOURCE_URL.getKey(), values.getProperty(Properties.SPRING_DATASOURCE_URL.getKey()));
        properties.put(Properties.SPRING_DATASOURCE_USERNAME.getKey(), values.getProperty(Properties.SPRING_DATASOURCE_USERNAME.getKey()));
        properties.put(Properties.SPRING_DATASOURCE_PASSWORD.getKey(), values.getProperty(Properties.SPRING_DATASOURCE_PASSWORD.getKey()));
        properties.put(Properties.SPRING_JPA_HIBERNATE_DDL_AUTO.getKey(), values.getProperty(Properties.SPRING_JPA_HIBERNATE_DDL_AUTO.getKey()));
        properties.put(Properties.SERVER_PORT.getKey(), values.getProperty(Properties.SERVER_PORT.getKey()));
        if (values.getProperty(Properties.SERVER_SSL.getKey()).equals("true")) {
            properties.put(Properties.SERVER_SSL.getKey(), values.getProperty(Properties.SERVER_SSL.getKey()));
            properties.put(Properties.SERVER_KEY_STORE.getKey(), values.getProperty(Properties.SERVER_KEY_STORE.getKey()));
            properties.put(Properties.SERVER_SSL_PASSWORD.getKey(), values.getProperty(Properties.SERVER_SSL_PASSWORD.getKey()));
            properties.put(Properties.SERVER_KEY_STORE_TYPE.getKey(), values.getProperty(Properties.SERVER_KEY_STORE_TYPE.getKey()));
            properties.put(Properties.SSL_KEY_ALIAS.getKey(), values.getProperty(Properties.SSL_KEY_ALIAS.getKey()));
        }

        springApplication.setDefaultProperties(properties);
        springApplication.run(args);
    }

    public static XddosApi getInstance() {
        return instance;
    }

    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/api").allowedOrigins("http://localhost:" + getInstance().getAuthProperties().getProperties().getProperty(Properties.SERVER_PORT.getKey()));
            }
        };
    }
}
