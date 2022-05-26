package vaina.cine.cine.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vaina.cine.cine.Modelos.Boleto;
import vaina.cine.cine.Modelos.Funcion;
import vaina.cine.cine.Modelos.Silla;
import vaina.cine.cine.Modelos.Usuario;
import vaina.cine.cine.Repositorios.RepositorioBoleto;
import vaina.cine.cine.Repositorios.RepositorioFuncion;
import vaina.cine.cine.Repositorios.RepositorioSilla;
import vaina.cine.cine.Repositorios.RepositorioUsuario;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/boletos")
public class ControladorBoleto {
    @Autowired
    private RepositorioBoleto miRepositorioBoleto;
    @Autowired
    private RepositorioUsuario miRepositorioUsuario;
    @Autowired
    private RepositorioFuncion miRepositorioFuncion;
    @Autowired
    private RepositorioSilla miRepositorioSilla;
    @GetMapping("")
    public List<Boleto> index(){
        return this.miRepositorioBoleto.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
            /*("silla/{id_silla}")
    public Boleto create(@RequestBody Boleto infoBoleto,@PathVariable String id_silla){
        Boleto nuevo=infoBoleto;
        Silla laSilla=this.miRepositorioSilla.findById(id_silla).get();
        nuevo.setSilla(laSilla);
        return this.miRepositorioBoleto.save(nuevo);
    }*/
    public Boleto create(@RequestBody Boleto infoBoleto){
        return this.miRepositorioBoleto.save(infoBoleto);
    }

    @GetMapping("{id}")
    public Boleto show(@PathVariable String id){
        Boleto esteBoleto=this.miRepositorioBoleto
                .findById(id)
                .orElseThrow(RuntimeException::new);
        return esteBoleto;
    }
    @PutMapping("{id}")
    public Boleto update(@PathVariable String id,@RequestBody Boleto infoBoleto){
        Boleto esteBoleto=this.miRepositorioBoleto
                .findById(id)
                .orElseThrow(RuntimeException::new);
        esteBoleto.setTipo(infoBoleto.getTipo());
        esteBoleto.setValor(infoBoleto.getValor());
        return this.miRepositorioBoleto.save(esteBoleto);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Boleto esteBoleto=this.miRepositorioBoleto
                .findById(id)
                .orElseThrow(RuntimeException::new);
        this.miRepositorioBoleto.delete(esteBoleto);
    }
    @PutMapping("{id}/usuario/{id_usuario}")
    public Boleto darBoletoUsuario(@PathVariable String id,@PathVariable String id_usuario){
        Boleto esteBoleto=this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        Usuario esteUsuario=this.miRepositorioUsuario.findById(id_usuario).orElseThrow(RuntimeException::new);
        esteBoleto.setUsuario(esteUsuario);
        return this.miRepositorioBoleto.save(esteBoleto);
    }
    @PutMapping("{id}/funcion/{id_funcion}")
    public Boleto darfuncion(@PathVariable String id,@PathVariable String id_funcion){
        Boleto esteBoleto=this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        Funcion estaFuncion=this.miRepositorioFuncion.findById(id_funcion).orElseThrow(RuntimeException::new);
        esteBoleto.setFuncion(estaFuncion);
        return this.miRepositorioBoleto.save(esteBoleto);
    }

    @PutMapping("{id}/silla/{id_silla}")
    public Boleto darsilla(@PathVariable String id,@PathVariable String id_silla){
        Boleto esteBoleto=this.miRepositorioBoleto.findById(id).orElseThrow(RuntimeException::new);
        Silla estaSilla=this.miRepositorioSilla.findById(id_silla).orElseThrow(RuntimeException::new);
        esteBoleto.setSilla(estaSilla);
        return this.miRepositorioBoleto.save(esteBoleto);
    }

}
