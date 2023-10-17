package it.Salfrance.SalfranceGamestore.controllers;

import it.Salfrance.SalfranceGamestore.models.Utente;
import it.Salfrance.SalfranceGamestore.services.UtenteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    private final UtenteService utenteConsole;

    public UtenteController(UtenteService utenteConsole) {
        this.utenteConsole = utenteConsole;
    }

    @PostMapping("/addutente")
    ResponseEntity<Utente> addTodo(@Valid@RequestBody Utente utente){
        utenteConsole.addUtente(utente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getutentebyid")
    ResponseEntity<Optional<Utente>> getById(@RequestParam Long id){
        utenteConsole.getUtenteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid")
    ResponseEntity<String> deleteById(@RequestParam Long id){
        utenteConsole.deleteUtenteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/putmapping")
    ResponseEntity<Utente> updateUtente(@RequestBody Utente utente){
        utenteConsole.updateUtente(utente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
