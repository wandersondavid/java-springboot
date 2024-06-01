package com.java_springboot.consumers;


import com.java_springboot.configs.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestReportPerson {
    @RabbitListener(bindings = @QueueBinding(value = @Queue(RabbitMQConfig.NOME_FILA),
            exchange = @Exchange(name = RabbitMQConfig.NOME_EXCHANGE),
            key = RabbitMQConfig.ROUTING_KEY))

    public void consumer(Message message) {
        System.out.println("Mensagem recebida: " + new String(message.getBody()));
    }
}