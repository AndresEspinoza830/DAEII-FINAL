package pe.isil.ExamenFinalDAE_II.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data //constructor metodos:set, get
@Entity //homologracion o relacion con tabla de la bd
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    @Column(name = "nom_completo")
    private String nombreCompleto;

    @NotBlank
    @Email
    private String email;

    private String password;

    @Transient
    @NotBlank
    private String password1;

    @Transient
    @NotBlank
    private String password2;

    public enum Rol{
        ADMIN,
        ESTUDIANTE,
        DOCENTE
    }

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @PrePersist
    @PreUpdate
    void asignarNombreCompleto(){
        nombreCompleto = nombres + " " + apellidos;
    }

}
