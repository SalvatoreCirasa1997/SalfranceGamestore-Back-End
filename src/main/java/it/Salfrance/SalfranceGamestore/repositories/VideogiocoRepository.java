package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.Utente;
import it.Salfrance.SalfranceGamestore.models.Videogioco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, Long> {

    Page<Videogioco> findAll(Pageable pageable);
}
