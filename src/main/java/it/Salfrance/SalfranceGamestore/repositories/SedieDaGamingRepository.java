package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.SedieDaGaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedieDaGamingRepository extends JpaRepository<SedieDaGaming,Long> {

    boolean existsById(Long id);
}
