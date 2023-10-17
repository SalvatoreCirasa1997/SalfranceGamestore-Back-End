package it.Salfrance.SalfranceGamestore.services;

import it.Salfrance.SalfranceGamestore.models.Videogioco;
import it.Salfrance.SalfranceGamestore.repositories.VideogiocoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VideogiocoService {

    private final VideogiocoRepository videogiocoRepository;

    public VideogiocoService(VideogiocoRepository videogiocoRepository) {
        this.videogiocoRepository = videogiocoRepository;
    }

    public Videogioco addVideogioco (Videogioco videogioco){return this.videogiocoRepository.save(videogioco);}

    public void removeVideogioco (Long id){this.videogiocoRepository.deleteById(id);}

    public Iterable<Videogioco> getAllVideogioco () {return this.videogiocoRepository.findAll();}

    public Optional<Videogioco> getVideogiocoById (Long id){return this.videogiocoRepository.findById(id);}

    public  Videogioco updateVideogioco (Videogioco videogioco){return  this.videogiocoRepository.save(videogioco);}

    public Page<Videogioco> getAll (Pageable pageable) {
        PageRequest pages = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return this.videogiocoRepository.findAll(pages);
    }
}
