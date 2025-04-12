package com.example.leavingrecordsystemapplicationlogicdemo.configuration;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JoopConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://aws-0-ap-southeast-1.pooler.supabase.com:5432/postgres");
        dataSource.setUsername("postgres.uahtliboppunuyfhxtfx");
        dataSource.setPassword("Nguyenducanh123@");
        return dataSource;
    }

    @Bean
    public DSLContext dslContext(DataSource dataSource) {
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }
}
