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
public class Reserva implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    @Column(nullable = false)
    private Double costoTotal;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFinal;

    @Column(nullable = false)
    private Integer cantidadDeClientes;

    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Cliente cliente;

    @ManyToOne
    @ToString.Exclude
    private Vuelo vuelo;

    @ManyToMany//DUDA CON ESTA RELACION
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private List<Silla> sillas;

    @ManyToMany
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    public Reserva (LocalDate fechaInicio, LocalDate fechaFinal, Integer cantidadDeClientes, Cliente cliente){
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.cantidadDeClientes = cantidadDeClientes;
        this.cliente = cliente;
    }

}
