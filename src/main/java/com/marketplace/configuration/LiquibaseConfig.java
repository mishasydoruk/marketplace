package com.marketplace.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {


  private final String dataSourceUrl;
  private final String dataSourceUsername;
  private final String dataSourcePassword;
  private final String driverClassName;

  private final Integer hikariConnectionTimeout;
  private final Integer hikariIdleTimeout;
  private final Integer hikariKeepAliveTime;
  private final Integer hikariMaxLifetime;
  private final Integer hikariMaxPoolSize;
  private final Integer hikariMinimumIdle;

  public LiquibaseConfig(
      @Value("${spring.datasource.url}") String dataSourceUrl,
      @Value("${spring.datasource.username}") String dataSourceUsername,
      @Value("${spring.datasource.password}") String dataSourcePassword,
      @Value("${spring.datasource.driver-class-name}") String driverClassName,
      @Value("${spring.datasource.hikari.connection-timeout}") Integer hikariConnectionTimeout,
      @Value("${spring.datasource.hikari.idle-timeout}") Integer hikariIdleTimeout,
      @Value("${spring.datasource.hikari.keepalive-time}") Integer hikariKeepAliveTime,
      @Value("${spring.datasource.hikari.max-lifetime}") Integer hikariMaxLifetime,
      @Value("${spring.datasource.hikari.maximum-pool-size}") Integer hikariMaxPoolSize,
      @Value("${spring.datasource.hikari.minimum-idle}") Integer hikariMinimumIdle) {
    this.dataSourceUrl = dataSourceUrl;
    this.dataSourceUsername = dataSourceUsername;
    this.dataSourcePassword = dataSourcePassword;
    this.driverClassName = driverClassName;
    this.hikariConnectionTimeout = hikariConnectionTimeout;
    this.hikariIdleTimeout = hikariIdleTimeout;
    this.hikariKeepAliveTime = hikariKeepAliveTime;
    this.hikariMaxLifetime = hikariMaxLifetime;
    this.hikariMaxPoolSize = hikariMaxPoolSize;
    this.hikariMinimumIdle = hikariMinimumIdle;
  }

  @Bean("dataSource")
  public DataSource getDataSource() {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(dataSourceUrl);
    config.setUsername(dataSourceUsername);
    config.setPassword(dataSourcePassword);
    config.setDriverClassName(driverClassName);
    config.setConnectionTimeout(hikariConnectionTimeout);
    config.setIdleTimeout(hikariIdleTimeout);
    config.setKeepaliveTime(hikariKeepAliveTime);
    config.setMaxLifetime(hikariMaxLifetime);
    config.setMaximumPoolSize(hikariMaxPoolSize);
    config.setMinimumIdle(hikariMinimumIdle);

    return new HikariDataSource(config);
  }

  @Bean
  public SpringLiquibase liquibase(DataSource dataSource) {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:db/changelog.xml");
    liquibase.setDataSource(dataSource);
    return liquibase;
  }
}
