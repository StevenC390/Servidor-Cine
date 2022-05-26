package vaina.cine.cine.Modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()
public class Pelicula {
    @Id
    private String _id;
    private String nombre;
    private int year;
    private String tipo;

    public Pelicula(String nombre, int year, String tipo) {
        this.nombre = nombre;
        this.year = year;
        this.tipo = tipo;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
