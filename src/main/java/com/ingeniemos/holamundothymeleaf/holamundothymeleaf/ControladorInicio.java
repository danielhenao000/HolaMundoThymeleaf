package com.ingeniemos.holamundothymeleaf.holamundothymeleaf;

import com.ingeniemos.holamundothymeleaf.holamundothymeleaf.dominio.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.saludo}")
    public String saludos;

    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Hola mundo con Thymeleaf";
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludos", saludos);

        Persona persona = new Persona();
        persona.setNombre("Daniel");
        persona.setApellido("Henao");
        persona.setCelular("3218389898");
        persona.setCorreo("danielhenao@hotmail.com");

        Persona persona2 = new Persona();
        persona2.setNombre("Jose");
        persona2.setApellido("Zapata");
        persona2.setCelular("3218389898");
        persona2.setCorreo("danielhenao@hotmail.com");

        //var personas = new ArrayList();
        //personas.add(persona);
        //personas.add(persona2);

        var personas = Arrays.asList(persona, persona2);

        model.addAttribute("persona",persona);
        model.addAttribute("personas",personas);
        return "index";
    }
}
