package it.Salfrance.SalfranceGamestore.services;

import it.Salfrance.SalfranceGamestore.models.Accessorio;
import it.Salfrance.SalfranceGamestore.repositories.AccessorioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessorioService {
    private final AccessorioRepository accessorioRepository;

    public AccessorioService(AccessorioRepository accessorioRepository) {
        this.accessorioRepository = accessorioRepository;
    }

    public Accessorio addAccessorio (Accessorio accessorio){return this.accessorioRepository.save(accessorio);}

    public void removeAccessorio (Long id){this.accessorioRepository.deleteById(id);}

    public Iterable<Accessorio> getAllAccessorio () {return this.accessorioRepository.findAll();}

    public Optional<Accessorio> getAccessorioById (Long id){return this.accessorioRepository.findById(id);}

    public  Accessorio updateAccessorio (Accessorio accessorio){return  this.accessorioRepository.save(accessorio);}

    public Page<Accessorio> findAll(Pageable pageable){
        PageRequest pages = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<Accessorio> todos=accessorioRepository.findAll(pages);
        return todos;
    }
}
