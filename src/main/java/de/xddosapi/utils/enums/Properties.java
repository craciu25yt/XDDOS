package de.xddosapi.utils.enums;

import lombok.Getter;

@Getter
public enum Properties {

    SPRING_DATASOURCE_URL("spring.datasource.url", "jdbc:mysql://localhost:3306/waveguardauth"),
    SPRING_DATASOURCE_USERNAME("spring.datasource.username", "root"),
    SPRING_DATASOURCE_PASSWORD("spring.datasource.password", ""),
    SPRING_JPA_HIBERNATE_DDL_AUTO("spring.jpa.hibernate.ddl-auto", "update"),
    SERVER_PORT("server.port", "8080"),
    SERVER_SSL("security.require-ssl", "true"),
    SERVER_KEY_STORE("server.ssl.key-store", "/etc/letsencrypt/live/example.com/keystore.p12"),
    SERVER_SSL_PASSWORD("server.ssl.key-store-password", "<your-password>"),
    SERVER_KEY_STORE_TYPE("server.ssl.keyStoreType", "PKCS12"),
    SSL_KEY_ALIAS("server.ssl.keyAlias", "tomcat");

    private final String key;
    private final String standardValue;

    Properties(final String key, final String standardValue) {
        this.key = key;
        this.standardValue = standardValue;
    }
}