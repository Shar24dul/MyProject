package com.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 *
 * @author AJ Catambay of Bridging Code
 *
 */
@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory( ConnectionFactory connectionFactory) {

        DefaultJmsListenerContainerFactory factory
                = new DefaultJmsListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setConcurrency("5");

        return factory;
    }
}
