package pe.isil.ExamenFinalDAE_II.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.isil.ExamenFinalDAE_II.model.Estudiante;
import pe.isil.ExamenFinalDAE_II.repository.EstudianteRepository;
import pe.isil.ExamenFinalDAE_II.service.FileSystemStorageService;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    //index
    @GetMapping("")
    public String index(Model model){
        List<Estudiante> estudiantes = estudianteRepository.findAll();

        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes/index";
    }

    //store

    //obtener_id

    //editar

    //actualizar

    //eliminar

}
