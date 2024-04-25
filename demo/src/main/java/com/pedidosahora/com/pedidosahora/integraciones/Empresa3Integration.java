package com.pedidosahora.com.pedidosahora.integraciones;

import org.springframework.stereotype.Component;

import com.pedidosahora.com.pedidosahora.modelos.Mensaje;

@Component
public class Empresa3Integration {

    public void enviarMensaje(Mensaje mensaje) {
        // Aquí se implementaría la lógica de integración con la Empresa 3
        // para enviar el mensaje a su sistema de mensajería
        
        // Ejemplo de código ficticio para enviar el mensaje
        System.out.println("Enviando mensaje a la Empresa 3: " + mensaje.getTexto());
    }
}