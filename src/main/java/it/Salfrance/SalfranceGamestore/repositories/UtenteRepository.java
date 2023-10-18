package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.SedieDaGaming;
import it.Salfrance.SalfranceGamestore.models.Utente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long>, PagingAndSortingRepository<Utente,Long> {
    boolean existsById(Long id);
    Page<Utente> findAll(Pageable pageable);
    Optional<Utente> findByUsername(String username);

}
