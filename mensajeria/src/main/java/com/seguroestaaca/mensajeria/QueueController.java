package com.seguroestaaca.mensajeria;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/message/{mensaje}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> enviarMensaje(@PathVariable("mensaje") String mensaje) {
        rabbitMQSender.send(mensaje);
        return ResponseEntity.ok(mensaje);
    }
}
