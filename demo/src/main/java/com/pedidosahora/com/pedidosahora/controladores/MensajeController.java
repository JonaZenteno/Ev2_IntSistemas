package com.pedidosahora.com.pedidosahora.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedidosahora.com.pedidosahora.servicios.MensajeService;

@RestController
@RequestMapping("/mensajes")
public class MensajeController {

    private final MensajeService mensajeService;

    @Autowired
    public MensajeController(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }

    @PostMapping
    public ResponseEntity<String> recibirMensaje(@RequestBody String mensaje) {
        try {
            // Procesar el mensaje llamando al servicio correspondiente
            mensajeService.procesarMensaje(mensaje);
            return ResponseEntity.ok("Mensaje recibido y procesado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al procesar el mensaje: " + e.getMessage());
        }
    }
}