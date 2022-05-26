package vaina.cine.cine.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Sala {
    @Id
    private String _id;
    private String nombre;
    private boolean efectos;

    public Sala(String nombre, boolean efectos) {
        this.nombre = nombre;
        this.efectos = efectos;
    }

    public String get_id() {
        return _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEfectos() {
        return efectos;
    }

    public void setEfectos(boolean efectos) {
        this.efectos = efectos;
    }
}
