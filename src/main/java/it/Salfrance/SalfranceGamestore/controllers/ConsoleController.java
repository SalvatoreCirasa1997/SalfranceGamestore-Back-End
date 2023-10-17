package it.Salfrance.SalfranceGamestore.controllers;

import it.Salfrance.SalfranceGamestore.models.Console;
import it.Salfrance.SalfranceGamestore.services.ConsoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/console")
public class ConsoleController {
    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @PostMapping("/addconsole")
    ResponseEntity<Console> addConsole(@RequestBody Console console){
        consoleService.saveConsole(console);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getbyid")
    ResponseEntity<Optional<Console>> getConsoleById(@RequestParam Long id){
        consoleService.getConsoleById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid")
    ResponseEntity<String> deleteById(@RequestParam Long id){
        consoleService.deleteConsole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/putconsole")
    ResponseEntity<Console> putConsole(@RequestBody Console console){
        consoleService.updateConsole(console);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
