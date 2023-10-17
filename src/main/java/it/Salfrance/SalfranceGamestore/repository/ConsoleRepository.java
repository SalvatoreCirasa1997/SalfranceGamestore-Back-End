package it.Salfrance.SalfranceGamestore.repository;

import it.Salfrance.SalfranceGamestore.models.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console,Long> {
    boolean existsById(Long id);
}
