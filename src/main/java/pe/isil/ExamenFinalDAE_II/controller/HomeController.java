package pe.isil.ExamenFinalDAE_II.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.isil.ExamenFinalDAE_II.model.Curso;
import pe.isil.ExamenFinalDAE_II.repository.CursoRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("home")
    String index(Model model){
        //mensaje de bienvenida al usuario
        return "home";
    }
}
