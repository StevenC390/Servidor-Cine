package vaina.cine.cine.Repositorios;

import vaina.cine.cine.Modelos.Boleto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioBoleto extends MongoRepository<Boleto,String> {
}
