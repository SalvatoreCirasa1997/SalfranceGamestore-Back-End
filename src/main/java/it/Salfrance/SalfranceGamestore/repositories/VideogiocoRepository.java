package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.Videogioco;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, Long> , PagingAndSortingRepository<Videogioco,Long> {

    Page<Videogioco> findAll(Pageable pageable);
}
