package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Ciudad implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @Length(min=3, max=100,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Hotel> hoteles;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Vuelo> vuelos;

    @OneToMany(mappedBy = "origen", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Vuelo> vuelos2;

    @OneToMany(mappedBy = "ciudad")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<Cliente> clientes;

}
