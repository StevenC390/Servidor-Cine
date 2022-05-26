package vaina.cine.cine.Modelos;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document()

public class Usuario {
    @Id
    private String _id;
    private String cedula;
    private String nombre;
    private String email;
    private int birth;

    public Usuario(String cedula, String nombre, String email, int birth) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
        this.birth = birth;
    }

    public String get_id() {
        return _id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
}
