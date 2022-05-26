package vaina.cine.cine.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaina.cine.cine.Modelos.Pelicula;
import vaina.cine.cine.Repositorios.RepositorioPelicula;


import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/peliculas")
public class ControladorPelicula {
    @Autowired
    private RepositorioPelicula miRepositorioPelicula;
    @GetMapping("")
    public List<Pelicula> index(){
        return this.miRepositorioPelicula.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pelicula create(@RequestBody Pelicula infoPelicula){
        return this.miRepositorioPelicula.save(infoPelicula);
    }
    @GetMapping("{id}")
    public Pelicula show(@PathVariable String id){
        Pelicula estaPelicula=this.miRepositorioPelicula
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return estaPelicula;
    }
    @PutMapping("{id}")
    public Pelicula update(@PathVariable String id,@RequestBody Pelicula infoPelicula){
        Pelicula estaPelicula=this.miRepositorioPelicula
                .findById(id)
                .orElseThrow(RuntimeException::new);
        estaPelicula.setYear(infoPelicula.getYear());
        estaPelicula.setTipo(infoPelicula.getTipo());
        estaPelicula.setNombre(infoPelicula.getNombre());
        return this.miRepositorioPelicula.save(estaPelicula);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Pelicula estaPelicula=this.miRepositorioPelicula
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioPelicula.delete(estaPelicula);
    }
}
