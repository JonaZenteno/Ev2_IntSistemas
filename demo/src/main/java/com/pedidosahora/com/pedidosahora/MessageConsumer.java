package com.pedidosahora.com.pedidosahora;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "myQueue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // Realizar acciones adicionales con el mensaje recibido
    }
}