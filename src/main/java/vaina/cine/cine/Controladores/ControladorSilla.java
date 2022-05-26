package vaina.cine.cine.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaina.cine.cine.Modelos.Boleto;
import vaina.cine.cine.Modelos.Funcion;
import vaina.cine.cine.Modelos.Sala;
import vaina.cine.cine.Modelos.Silla;
import vaina.cine.cine.Repositorios.RepositorioSala;
import vaina.cine.cine.Repositorios.RepositorioSilla;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/sillas")
public class ControladorSilla {
    @Autowired
    private RepositorioSilla miRepositorioSilla;
    @Autowired
    private RepositorioSala miRepositorioSala;
    @GetMapping("")
    public List<Silla> index(){
        return this.miRepositorioSilla.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Silla create(@RequestBody Silla infoSilla){
        return this.miRepositorioSilla.save(infoSilla);
    }
    @GetMapping("{id}")
    public Silla show(@PathVariable String id){
        Silla estaSilla=this.miRepositorioSilla
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return estaSilla;
    }
    @PutMapping("{id}")
    public Silla update(@PathVariable String id,@RequestBody Silla infoSilla){
        Silla estaSilla=this.miRepositorioSilla
                .findById(id)
                .orElseThrow(RuntimeException::new);
        estaSilla.setLetra(infoSilla.getLetra());
        estaSilla.setNumero(infoSilla.getNumero());
        return this.miRepositorioSilla.save(estaSilla);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Silla estaSilla=this.miRepositorioSilla
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioSilla.delete(estaSilla);
    }
    @PutMapping("{id}/sala/{id_sala}")
    public Silla darsala(@PathVariable String id, @PathVariable String id_sala){
        Silla estaSilla=this.miRepositorioSilla.findById(id).orElseThrow(RuntimeException::new);
        Sala estaSala=this.miRepositorioSala.findById(id_sala).orElseThrow(RuntimeException::new);
        estaSilla.setSala(estaSala);
        return this.miRepositorioSilla.save(estaSilla);
    }
}
