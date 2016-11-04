package com.github.dmandg;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dmand on 30/10/2016.
 */
@Configuration
public class DerekConfig {

    @Bean
    public MessageProvider getMessage() {
        return new MessageProvider() {
            @Override
            public String getMessage() {
                return "Hello, there";
            }
        };
    }

    @Bean
    public Connection getDatabase() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:howtodoinjava", "sa", "");
        return c;
    }

    @Bean
    public SessionFactory getSessionFactory() throws SQLException {
        return HibernateUtil.getSessionFactory();
    }

}


