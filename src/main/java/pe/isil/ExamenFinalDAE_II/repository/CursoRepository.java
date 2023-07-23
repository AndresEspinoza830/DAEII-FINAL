package pe.isil.ExamenFinalDAE_II.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.ExamenFinalDAE_II.model.Curso;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    //1. seleccione los primeros 8 cursos por fecha de creacion
    List<Curso> findTop8ByOrderByFechaCreacionDesc();

    //2. seleccione los cursos que contengan el titulo = ? y ademas sea pageable
    Page<Curso> findByTituloContaining(String titulo, Pageable pageable);

}
