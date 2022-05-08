package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class AdministradorHotel extends Persona implements Serializable {


    @Column(nullable = false, unique = true)
    private Integer codigo;

    @OneToMany(mappedBy = "administradorHotel", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Hotel> hoteles;

    public AdministradorHotel(String cedula, String nombre, String email, String password, Integer codigo) {
        super(cedula, nombre, email, password);
        this.codigo = codigo;
    }
}
