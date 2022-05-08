package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;
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
public class Caracteristica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private Integer codigo;

    @Column(nullable = false)
    @NotBlank
    @Length(min=3, max=200,message ="El contenido debe tener entre 3 y 200 caracteres")
    private String contenido;

    @ManyToMany
    @Column(nullable = false)
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToMany
    @Column(nullable = false)
    @ToString.Exclude
    private List<Hotel> hoteles;

}
