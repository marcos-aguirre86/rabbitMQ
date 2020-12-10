package com.seguroestaaca.mensajeria;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ServiceMq implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("----Obteniendo mensaje de la QUEUE RABBIT-----" + message);
    }
}
