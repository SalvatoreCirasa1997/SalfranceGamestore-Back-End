package it.Salfrance.SalfranceGamestore.controllers;

import it.Salfrance.SalfranceGamestore.models.Console;
import it.Salfrance.SalfranceGamestore.models.Utente;
import it.Salfrance.SalfranceGamestore.services.UtenteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    ResponseEntity<Utente> addTodo(@Valid @RequestBody Utente utente){
        utenteConsole.addUtente(utente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getall")
    ResponseEntity<Page<Utente>> getall(@PageableDefault(page=0,size = 8)
                                         Pageable pageable){
        return new ResponseEntity<>(this.utenteConsole.getAll(pageable),HttpStatus.OK);
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
    ResponseEntity<Utente> updateUtente(@Valid @RequestBody Utente utente){
        utenteConsole.updateUtente(utente);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
