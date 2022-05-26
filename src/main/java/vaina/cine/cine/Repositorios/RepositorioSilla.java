package vaina.cine.cine.Repositorios;

import vaina.cine.cine.Modelos.Silla;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioSilla extends MongoRepository<Silla,String> {
}
