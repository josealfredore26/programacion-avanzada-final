package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class  Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private boolean disponibilidad;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Vuelo vuelo;

    @Column(nullable = false)
    private Double valor;

    @ManyToMany(mappedBy = "sillas")
    @ToString.Exclude
    private List<Reserva> reservas;
}
