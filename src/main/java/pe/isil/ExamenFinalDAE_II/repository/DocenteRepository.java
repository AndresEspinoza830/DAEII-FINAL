package pe.isil.ExamenFinalDAE_II.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.ExamenFinalDAE_II.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}
