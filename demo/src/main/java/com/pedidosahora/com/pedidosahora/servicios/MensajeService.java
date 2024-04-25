package com.pedidosahora.com.pedidosahora.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedidosahora.com.pedidosahora.filtros.FiltroMensajes;
import com.pedidosahora.com.pedidosahora.integraciones.Empresa1Integration;
import com.pedidosahora.com.pedidosahora.integraciones.Empresa2Integration;
import com.pedidosahora.com.pedidosahora.integraciones.Empresa3Integration;
import com.pedidosahora.com.pedidosahora.modelos.Mensaje;

@Service
public class MensajeService {

    private final Empresa1Integration empresa1Integration;
    private final Empresa2Integration empresa2Integration;
    private final Empresa3Integration empresa3Integration;
    private final FiltroMensajes filtroMensajes;

    @Autowired
    public MensajeService(Empresa1Integration empresa1Integration,
                        Empresa2Integration empresa2Integration,
                        Empresa3Integration empresa3Integration,
                        FiltroMensajes filtroMensajes) {
        this.empresa1Integration = empresa1Integration;
        this.empresa2Integration = empresa2Integration;
        this.empresa3Integration = empresa3Integration;
        this.filtroMensajes = filtroMensajes;
    }

    public void procesarMensaje(String mensajeTexto) {
        Mensaje mensaje = new Mensaje(mensajeTexto);

        // Aplicar filtro de mensajes no deseados
        if (filtroMensajes.esMensajeNoDeseado(mensaje)) {
            return; // Ignorar el mensaje no deseado
        }

        // Obtener información adicional del servidor de la empresa
        obtenerInformacionAdicional(mensaje);

        // Enviar el mensaje a las empresas de pedidos
        empresa1Integration.enviarMensaje(mensaje);
        empresa2Integration.enviarMensaje(mensaje);
        empresa3Integration.enviarMensaje(mensaje);
        
        // Aquí se puede agregar más lógica de procesamiento según los requisitos del sistema
    }

    private void obtenerInformacionAdicional(Mensaje mensaje) {
        // Lógica para obtener información adicional del servidor de la empresa
        // y actualizar el mensaje con los datos obtenidos
    }
}