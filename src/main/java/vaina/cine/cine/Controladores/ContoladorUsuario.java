package vaina.cine.cine.Controladores;

import com.mongodb.internal.connection.ConcurrentPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaina.cine.cine.Modelos.Usuario;
import vaina.cine.cine.Repositorios.RepositorioUsuario;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class ContoladorUsuario {
    @Autowired
    private RepositorioUsuario miRepositorioUsuario;
    @GetMapping("")
    public List<Usuario> index(){
        return this.miRepositorioUsuario.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario){
        return this.miRepositorioUsuario.save(infoUsuario);
    }
    @GetMapping("{id}")
    public Usuario show(@PathVariable String id){
        Usuario esteUsuario=this.miRepositorioUsuario
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return esteUsuario;
    }
    @PutMapping("{id}")
    public Usuario update(@PathVariable String id,@RequestBody Usuario infoUsuario){
        Usuario esteUsuario=this.miRepositorioUsuario
                .findById(id)
                .orElseThrow(RuntimeException::new);
        esteUsuario.setBirth(infoUsuario.getBirth());
        esteUsuario.setCedula(infoUsuario.getCedula());
        esteUsuario.setEmail(infoUsuario.getEmail());
        esteUsuario.setNombre(infoUsuario.getNombre());
        return this.miRepositorioUsuario.save(esteUsuario);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Usuario esteUsuario=this.miRepositorioUsuario
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioUsuario.delete(esteUsuario);
    }
}
