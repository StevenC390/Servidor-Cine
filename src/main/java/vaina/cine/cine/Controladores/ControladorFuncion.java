package vaina.cine.cine.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaina.cine.cine.Modelos.Boleto;
import vaina.cine.cine.Modelos.Funcion;
import vaina.cine.cine.Modelos.Pelicula;
import vaina.cine.cine.Modelos.Sala;
import vaina.cine.cine.Repositorios.RepositorioFuncion;
import vaina.cine.cine.Repositorios.RepositorioPelicula;
import vaina.cine.cine.Repositorios.RepositorioSala;


import java.lang.module.ResolutionException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/funciones")

//Clase intermedia de muchos a muchos

public class ControladorFuncion {
    @Autowired
    private RepositorioFuncion miRepositorioFuncion;
    @Autowired
    private RepositorioPelicula miRepositorioPelicula;
    @Autowired
    private RepositorioSala miRepositorioSala;
    @GetMapping("")
    public List<Funcion> index(){
        return this.miRepositorioFuncion.findAll();
    }
    //Asignar sala y pelicula
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("sala/{id_sala}/pelicula/{id_pelicula}")
    public Funcion create(@RequestBody Funcion infoFuncion,@PathVariable String id_sala,@PathVariable String id_pelicula){
        Funcion nueva=infoFuncion;
        Sala laSala=this.miRepositorioSala.findById(id_sala).get();
        Pelicula laPelicula=this.miRepositorioPelicula.findById(id_pelicula).get();
        nueva.setSala(laSala);
        nueva.setPelicula(laPelicula);
        return this.miRepositorioFuncion.save(nueva);
    }
    @GetMapping("{id}")
    public Funcion show(@PathVariable String id){
        Funcion estaFuncion=this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        return estaFuncion;
    }
    //Modificar sala y pelicula
    @PutMapping("{id}/sala/{id_sala}/pelicula/{id_pelicula}")
    public Funcion update(@PathVariable String id,@PathVariable String id_sala,@PathVariable String id_pelicula){
        Funcion estaFuncion=this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        Sala laSala=this.miRepositorioSala.findById(id_sala).get();
        Pelicula laPelicula=this.miRepositorioPelicula.findById(id_pelicula).get();
        estaFuncion.setSala(laSala);
        estaFuncion.setPelicula(laPelicula);
        return this.miRepositorioFuncion.save(estaFuncion);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Funcion estaFuncion=this.miRepositorioFuncion.findById(id).orElseThrow(RuntimeException::new);
        this.miRepositorioFuncion.delete(estaFuncion);
    }
}
