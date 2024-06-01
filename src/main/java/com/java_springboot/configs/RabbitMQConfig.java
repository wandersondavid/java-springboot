package com.java_springboot.configs;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String NOME_FILA = "report-queue";
    public static final String NOME_EXCHANGE = "report-exchange";
    public static final String ROUTING_KEY = "report-key";

    @Bean
    DirectExchange requestReport() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    @Bean
    Queue queue() {
        return QueueBuilder.durable(NOME_FILA).build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(requestReport()).with(ROUTING_KEY);
    }
}
