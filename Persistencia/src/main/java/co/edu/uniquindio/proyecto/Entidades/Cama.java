package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Cama implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Integer numero;

//    @ToString.Exclude
    @Column(nullable = false)
    private TipoCama tipo;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Habitacion habitacion;

}
