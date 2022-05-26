package vaina.cine.cine.Repositorios;

import vaina.cine.cine.Modelos.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPelicula extends MongoRepository<Pelicula,String > {
}
