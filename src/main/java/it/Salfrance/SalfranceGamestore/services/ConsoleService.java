package it.Salfrance.SalfranceGamestore.services;

import it.Salfrance.SalfranceGamestore.models.Console;
import it.Salfrance.SalfranceGamestore.repositories.ConsoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsoleService {
    private final ConsoleRepository consoleRepository;

    public ConsoleService(ConsoleRepository consoleRepository) {
        this.consoleRepository = consoleRepository;
    }

    public Console saveConsole(Console console) {
        Console console1 = new Console();
        console1.setMarca(console.getMarca());
        console1.setModello(console.getModello());
        console1.setColors(console.getColors());
        console1.setPrezzo(console.getPrezzo());
        console1.setDescrizione(console.getDescrizione());
        console1.setHardDisk(console.getHardDisk());
        console1.setQuantitaDisponibile(console.getQuantitaDisponibile() + 1);
        console1.setUrlImmagine(console.getUrlImmagine());
        return consoleRepository.save(console1);
    }

    public List<Console> getAll(){
        return consoleRepository.findAll();
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
