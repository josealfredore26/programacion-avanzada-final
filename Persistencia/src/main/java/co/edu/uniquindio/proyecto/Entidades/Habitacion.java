package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Habitacion implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Double precio;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Cama> camas;

    @ElementCollection//(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private List<String> ruta;

    @ManyToMany(mappedBy = "habitaciones", cascade = CascadeType.ALL)
    private List<Caracteristica> caracteristicas;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Hotel hotel;

    @ManyToMany(mappedBy = "habitaciones", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Reserva> reservas;
}
