package com.example.h2databasedemomaven.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class H2Configuration {
    @Bean("h2DataSource")
    public static final EmbeddedDatabase dataSource(){
        log.info("Connecting to h2 database");
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).
                addScripts("data.sql").build();
    }
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource h2DataSource){
        return new NamedParameterJdbcTemplate(h2DataSource);
    }
}
