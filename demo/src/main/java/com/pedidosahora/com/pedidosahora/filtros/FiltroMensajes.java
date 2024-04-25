package com.pedidosahora.com.pedidosahora.filtros;

import org.springframework.stereotype.Component;

import com.pedidosahora.com.pedidosahora.modelos.Mensaje;

@Component
public class FiltroMensajes {

    public boolean esMensajeNoDeseado(Mensaje mensaje) {
        // Aquí se implementaría la lógica para determinar si un mensaje es considerado no deseado
        
        // Ejemplo de código ficticio para el filtro de mensajes no deseados
        String texto = mensaje.getTexto().toLowerCase();
        return texto.contains("spam") || texto.contains("publicidad");
    }
}