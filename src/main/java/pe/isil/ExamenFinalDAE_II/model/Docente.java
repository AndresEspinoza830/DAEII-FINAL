package pe.isil.ExamenFinalDAE_II.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 2, max=100)
    private String nombres;

    @NotNull
    @NotBlank
    @Size(min = 2, max=100)
    private String apellidos;

    @NotNull
    @NotBlank
    @Size(min=8, max=15)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max=200)
    private String direccion;

    @NotNull
    @NotBlank
    @Size(min=6, max=15)
    private String telefono;

}
