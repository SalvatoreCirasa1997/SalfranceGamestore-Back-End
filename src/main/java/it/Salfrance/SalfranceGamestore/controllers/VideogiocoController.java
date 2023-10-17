package it.Salfrance.SalfranceGamestore.controllers;

import it.Salfrance.SalfranceGamestore.models.Videogioco;
import it.Salfrance.SalfranceGamestore.services.VideogiocoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/videogioco")
public class VideogiocoController {
    private final VideogiocoService videogiocoService;

    public VideogiocoController(VideogiocoService videogiocoService) {
        this.videogiocoService = videogiocoService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Videogioco>> getVideogiochi(@PageableDefault(page=0,size = 8)
                                                               Pageable pageable){
            return new ResponseEntity<>(this.videogiocoService.getAll(pageable), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addVideogioco(@RequestBody Videogioco videogioco) {
        try {
            Videogioco videogiocoAdded = this.videogiocoService.addVideogioco(videogioco);
            return new ResponseEntity<>(videogiocoAdded, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(500));
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Videogioco> removeVideogioco(@PathVariable Long id){
        this.videogiocoService.removeVideogioco(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get{id}")
    public ResponseEntity<?> getVideogiocoByID(@PathVariable Long id){
        Optional<Videogioco> videogioco = this.videogiocoService.getVideogiocoById(id);
        if(videogioco.isEmpty()){
            return new ResponseEntity<>("Non esiste!",HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(videogioco.get(),HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Videogioco> updateVideogioco (@RequestBody Videogioco videogioco){
        try {
            Videogioco videogiocoUpdate = this.videogiocoService.updateVideogioco(videogioco);
            return new ResponseEntity<>(videogiocoUpdate, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
