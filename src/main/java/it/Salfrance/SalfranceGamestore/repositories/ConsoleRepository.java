package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.Accessorio;
import it.Salfrance.SalfranceGamestore.models.Console;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console,Long> {
    boolean existsById(Long id);
    Page<Console> findAll(Pageable pageable);
}
