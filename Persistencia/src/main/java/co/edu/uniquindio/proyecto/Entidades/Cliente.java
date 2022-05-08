package co.edu.uniquindio.proyecto.Entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
public class Cliente extends Persona implements Serializable {

    @ElementCollection
    private List<String> telefono;

    @JoinColumn(nullable = true)
    @ManyToOne
    @ToString.Exclude
    private Ciudad ciudad;

    @OneToMany(mappedBy = "cliente")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<Reserva> reservas;

    public Cliente(String cedula, String nombre, String email, String password, List<String> telefono, Ciudad ciudad) {
        super(cedula, nombre, email, password);
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

}
