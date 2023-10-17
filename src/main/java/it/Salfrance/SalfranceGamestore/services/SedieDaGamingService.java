package it.Salfrance.SalfranceGamestore.services;

import it.Salfrance.SalfranceGamestore.models.SedieDaGaming;
import it.Salfrance.SalfranceGamestore.repositories.SedieDaGamingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SedieDaGamingService {
    private final SedieDaGamingRepository sedieDaGamingRepository;

    public SedieDaGamingService(SedieDaGamingRepository sedieDaGamingRepository) {
        this.sedieDaGamingRepository = sedieDaGamingRepository;
    }

    public SedieDaGaming saveSediaDaGaming(SedieDaGaming sedieDaGaming){
        return sedieDaGamingRepository.save(sedieDaGaming);
    }

    public Optional<SedieDaGaming> getSediaById(Long id){
        if(sedieDaGamingRepository.existsById(id)){
            return sedieDaGamingRepository.findById(id);
        }
        else return Optional.empty();
    }

    public SedieDaGaming updateSedieDaGaming(SedieDaGaming sedieDaGaming){
        return sedieDaGamingRepository.save(sedieDaGaming);
    }

    public String deleteById(Long id){
        if(sedieDaGamingRepository.existsById(id)){
            sedieDaGamingRepository.deleteById(id);
            return "sedia da gaming eliminata";
        }
       else {
           return "non c'è una sedia con quell id";
        }
    }
}

