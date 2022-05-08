package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Vuelo implements Serializable {

    @Id
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Ciudad origen;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Ciudad destino;

    @Column(nullable = false)
    private Integer cantidadDeSillas;

    @Column(nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Silla> sillas;

    public Vuelo (Ciudad origen, Ciudad destino, Integer cantidadDeSillas, LocalDate fecha){
        this.origen = origen;
        this.destino = destino;
        this.cantidadDeSillas = cantidadDeSillas;
        this.fecha = fecha;
    }

}
