package co.edu.uniquindio.proyecto.Entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Administrador extends Persona implements Serializable {

    @Column(nullable = false, unique = true)
    private Integer codigo;

    public Administrador(String cedula, String nombre, String email, String password, Integer codigo) {
        super(cedula, nombre, email, password);
        this.codigo = codigo;
    }

}
