package pe.isil.ExamenFinalDAE_II.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.isil.ExamenFinalDAE_II.model.Usuario;
import pe.isil.ExamenFinalDAE_II.repository.UsuarioRepository;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String index(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/registro")
    public String crear(@Validated Usuario usuario, BindingResult br, RedirectAttributes ra, Model model){
        if (br.hasErrors()){
            model.addAttribute("usuario", usuario);
            return "registro";
        }

        //validar la unicidad o unico del correo electronico
        String email = usuario.getEmail();
        boolean usuarioYaExiste = usuarioRepository.existsByEmail(email);

        if (usuarioYaExiste){
            br.rejectValue("email", "EmailAlreadyExists");
        }

        //validar las contraseñas coincidan
        if (!usuario.getPassword1().equals(usuario.getPassword2())){
            br.rejectValue("password1", "PasswordNotEquals");
        }

        if (br.hasErrors()){
            model.addAttribute("usuario", usuario);
            return "registro";
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword1()));

        usuario.setRol(usuario.getRol());

        usuarioRepository.save(usuario);

        ra.addFlashAttribute("registroExitoso","");
        return "redirect:/login";
    }


}
