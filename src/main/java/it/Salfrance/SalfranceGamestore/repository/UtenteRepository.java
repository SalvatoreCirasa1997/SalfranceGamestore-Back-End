package it.Salfrance.SalfranceGamestore.repository;

import it.Salfrance.SalfranceGamestore.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {
    boolean existsById(Long id);

}
