package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.Console;
import it.Salfrance.SalfranceGamestore.models.SedieDaGaming;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface SedieDaGamingRepository extends JpaRepository<SedieDaGaming,Long>, PagingAndSortingRepository<SedieDaGaming,Long> {
    Page<SedieDaGaming> findAll(Pageable pageable);
    boolean existsById(Long id);
}
