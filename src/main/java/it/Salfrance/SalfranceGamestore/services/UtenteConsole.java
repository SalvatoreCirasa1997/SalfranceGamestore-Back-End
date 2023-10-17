package it.Salfrance.SalfranceGamestore.services;

import it.Salfrance.SalfranceGamestore.models.Utente;
import it.Salfrance.SalfranceGamestore.repository.UtenteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UtenteConsole {
    private final UtenteRepository utenteRepository;

    public UtenteConsole(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente addUtente(Utente utente){
        return utenteRepository.save(utente);
    }

    public Optional<Utente> getUtenteById(Long id){
        if(utenteRepository.existsById(id)){
            return utenteRepository.findById(id);
        }
        else return Optional.empty();
    }

    public Utente updateUtente(Utente utente){
        return utenteRepository.save(utente);
    }

    public String deleteUtenteById(Long id){
        if(utenteRepository.existsById(id)){
            utenteRepository.deleteById(id);
            return "hai eliminato l'utente con quell id";
        }
        return "non hai un utente con quell id";
    }
}
