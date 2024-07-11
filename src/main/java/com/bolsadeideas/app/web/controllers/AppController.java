package com.bolsadeideas.app.web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Value("${config.horario.apertura}")
    private Integer apertura;

    @Value("${config.horario.cierre}")
    private Integer cierre;


    @GetMapping({"/hora", "/index", "/"})
    public String horario(Model model) {
        model.addAttribute("titulo", "Bienvenido al horario de atención a clientes");
        model.addAttribute("currentHour", java.time.LocalTime.now());
        return "horario";
    }

    @GetMapping("/cerrado")
    public String cerrado(Model model) {
        StringBuilder mensaje = new StringBuilder("Cerrado, visitenos desde las: ");
        mensaje.append(apertura).append(" a ").append(cierre).append(" horas.");
        model.addAttribute("titulo", "Página cerrada");
        model.addAttribute("mensaje", mensaje.toString());
        return "cerrado";
    }
}

