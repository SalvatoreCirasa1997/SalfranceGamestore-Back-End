package it.Salfrance.SalfranceGamestore.services;

import it.Salfrance.SalfranceGamestore.models.Console;
import it.Salfrance.SalfranceGamestore.repositories.ConsoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsoleService {
    private final ConsoleRepository consoleRepository;

    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public Console saveConsole(Console console) { return this.consoleRepository.save(console); }

    public Page<Console> findAll(Pageable pageable){
        PageRequest pages = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        return this.consoleRepository.findAll(pageable);
    }

    public Optional<Console>  getConsoleById(Long id){
      return consoleRepository.findById(id);
    }

    public Console updateConsole(Console console){
        return consoleRepository.save(console);
    }

    public String deleteConsole(Long id){
        if(consoleRepository.existsById(id)){
            consoleRepository.deleteById(id);
            return "console eliminato";
        }
        else {
            return "non c'è un utente con quell id";
        }
    }
}
