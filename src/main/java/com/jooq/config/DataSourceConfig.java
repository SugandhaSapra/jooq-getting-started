package com.jooq.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    public static DataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:15432/writerpad");
        config.setUsername("user");
        config.setPassword("password");
        config.setAutoCommit(true);
        config.setMaximumPoolSize(32);
        return new HikariDataSource(config);
    }
}
