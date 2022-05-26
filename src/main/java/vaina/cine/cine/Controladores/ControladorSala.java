package vaina.cine.cine.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaina.cine.cine.Modelos.Sala;
import vaina.cine.cine.Repositorios.RepositorioSala;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/salas")
public class ControladorSala {
    @Autowired
    private RepositorioSala miRepositorioSala;
    @GetMapping("")
    public List<Sala> index(){
        return this.miRepositorioSala.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Sala create(@RequestBody Sala infoSala){
        return this.miRepositorioSala.save(infoSala);
    }
    @GetMapping("{id}")
    public Sala show(@PathVariable String id){
        Sala estaSala=this.miRepositorioSala
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return estaSala;
    }
    @PutMapping("{id}")
    public Sala update(@PathVariable String id,@RequestBody Sala infoSala){
        Sala estaSala=this.miRepositorioSala
                .findById(id)
                .orElseThrow(RuntimeException::new);
        estaSala.setEfectos(infoSala.isEfectos());
        estaSala.setNombre(infoSala.getNombre());
        return this.miRepositorioSala.save(estaSala);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Sala estaSala=this.miRepositorioSala
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioSala.delete(estaSala);
    }
}
