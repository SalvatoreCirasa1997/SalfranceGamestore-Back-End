package it.Salfrance.SalfranceGamestore.controllers;

import it.Salfrance.SalfranceGamestore.models.Accessorio;
import it.Salfrance.SalfranceGamestore.services.AccessorioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/accessorio")
public class AccessorioController {
    private final AccessorioService accessorioService;

    public AccessorioController(AccessorioService accessorioService) {
        this.accessorioService = accessorioService;
    }

    @GetMapping("/all")
    public ResponseEntity <Page<Accessorio>> getAccessorio( @PageableDefault(page=0,size = 8)
                                               Pageable pageable){
        try {
            return new ResponseEntity<>(this.accessorioService.findAll(pageable), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<Accessorio> addAccessorio(@RequestBody Accessorio accessorio) {
        try {
            return new ResponseEntity<>(this.accessorioService.addAccessorio(accessorio), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Accessorio> removeAccessorio(@PathVariable Long id){
        this.accessorioService.removeAccessorio(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get{id}")
    public ResponseEntity<?> getAccessorioByID(@PathVariable Long id){
        Optional<Accessorio> accessorio = this.accessorioService.getAccessorioById(id);
        if(accessorio.isEmpty()){
            return new ResponseEntity<>("Non esiste!",HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(accessorio.get(),HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Accessorio> updateAccessorio (@RequestBody Accessorio accessorio){
        try {
            Accessorio accessorioUpdate = this.accessorioService.updateAccessorio(accessorio);
            return new ResponseEntity<>(accessorioUpdate, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
