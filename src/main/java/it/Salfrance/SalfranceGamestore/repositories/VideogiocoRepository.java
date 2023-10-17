package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.Videogioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, Long> {

}
