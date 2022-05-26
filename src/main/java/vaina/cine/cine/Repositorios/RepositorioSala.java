package vaina.cine.cine.Repositorios;

import vaina.cine.cine.Modelos.Sala;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioSala extends MongoRepository<Sala,String> {
}
