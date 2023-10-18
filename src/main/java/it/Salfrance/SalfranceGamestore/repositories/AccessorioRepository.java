package it.Salfrance.SalfranceGamestore.repositories;

import it.Salfrance.SalfranceGamestore.models.Accessorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessorioRepository extends JpaRepository<Accessorio,Long>, PagingAndSortingRepository<Accessorio,Long> {

     Page<Accessorio> findAll(Pageable pageable);
}
