package com.learn.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:jdbc.properties")
//@ConfigurationProperties(prefix = "jdbc")
public class DataSourceConfiguration {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

//    @Bean("dataSource")
    @Bean
    public ComboPooledDataSource getDataSource() throws PropertyVetoException {

        System.out.println("============================================url:"+url+"=========================================");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        // 关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
