package it.Salfrance.SalfranceGamestore.controllers;

import it.Salfrance.SalfranceGamestore.models.Console;
import it.Salfrance.SalfranceGamestore.models.SedieDaGaming;
import it.Salfrance.SalfranceGamestore.services.SedieDaGamingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sediedagaming")
public class SedieDaGamingController {
    private final SedieDaGamingService sediadagamingservice;

    public SedieDaGamingController(SedieDaGamingService sediadagamingservice) {
        this.sediadagamingservice = sediadagamingservice;
    }

    @PostMapping("/addsedia")
    ResponseEntity<SedieDaGaming> addSedia(@RequestBody SedieDaGaming sedieDaGaming){
        sediadagamingservice.saveSediaDaGaming(sedieDaGaming);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getsediabyid")
    ResponseEntity<Optional<SedieDaGaming>> getSediaById(@RequestParam Long id){
        sediadagamingservice.getSediaById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid")
    ResponseEntity<String> deleteById(@RequestParam Long id){
        sediadagamingservice.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/updatesedia")
    ResponseEntity<SedieDaGaming> updateSediaDaGaming(@RequestBody SedieDaGaming sedieDaGaming){
        sediadagamingservice.updateSedieDaGaming(sedieDaGaming);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getall")
    ResponseEntity<Page<SedieDaGaming>> getall(@PageableDefault(page=0,size = 8)
                                         Pageable pageable){
        return new ResponseEntity<>(this.sediadagamingservice.getAll(pageable),HttpStatus.OK);
    }
}
