package com.marketav;

import com.marketav.commons.implemented.WildCardConverter;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class MarketAvJdbcApplicationConfig {
    //TODO: Create a service to delete all users from the database.
    public static void main(String[] args) {
        SpringApplication.run(MarketAvJdbcApplicationConfig.class, args);
    }

    @Bean
    WildCardConverter wildCardConverter() {
        return new WildCardConverter("%");
    }

    @Bean
    @ConfigurationProperties(prefix = "app.datasource")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
