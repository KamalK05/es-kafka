package com.in.eskafka.config.db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "esKafkaEntityManagerFactory",
        transactionManagerRef = "esKafkaTransactionManager",
        basePackages = {"com.in.eskafka.dataaccess.rds"}
)
public class EsKafkaDbConfig {
    @Primary
    @Bean(name = "esKafkaDataSource")
    @ConfigurationProperties(prefix = "com.in.eskafka.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "esKafkaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean esKafkaEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("esKafkaDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.in.eskafka.entity")
                .persistenceUnit("readwrite")
                .build();
    }

    @Primary
    @Bean(name = "esKafkaTransactionManager")
    public PlatformTransactionManager esKafkaTransactionManager(@Qualifier("esKafkaEntityManagerFactory") EntityManagerFactory esKafkaEntityManagerFactory) {
        return new JpaTransactionManager(esKafkaEntityManagerFactory);
    }
}
