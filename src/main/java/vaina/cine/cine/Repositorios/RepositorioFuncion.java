package vaina.cine.cine.Repositorios;

import vaina.cine.cine.Modelos.Funcion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioFuncion extends MongoRepository<Funcion,String> {
}
