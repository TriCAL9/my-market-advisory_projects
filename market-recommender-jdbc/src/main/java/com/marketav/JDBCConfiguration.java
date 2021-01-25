package com.marketav;


import com.marketav.commons.implemented.WildCardConverter;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootConfiguration
@EnableJdbcRepositories
public class JDBCConfiguration extends AbstractJdbcConfiguration {
    @Bean
    WildCardConverter wildCardConverter() {
        return new WildCardConverter("%");
    }

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
