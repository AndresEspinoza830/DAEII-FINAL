package pe.isil.ExamenFinalDAE_II.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.ExamenFinalDAE_II.model.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email); //SELECT * FROM USUARIO WHERE EMAIL=?

    boolean existsByEmail(String email); //RETURN EXISTS(SELECT * FROM USUARIO WHERE EMAIL=?)
}
