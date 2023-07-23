package pe.isil.ExamenFinalDAE_II.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("mis-cursos")
    public String misCursos(){
        return "mis-cursos";
    }

}



