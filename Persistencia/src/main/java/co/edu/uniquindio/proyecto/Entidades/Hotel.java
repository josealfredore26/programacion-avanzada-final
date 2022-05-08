package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @NotBlank
    @Column(nullable = false)
    @Length(min = 3, max = 100, message = "El nombre del hotel tiene que tener entre 3 y 20 caracteres")
    private String nombre;

    @NotBlank
    @Column(nullable = false)
    @Length(min = 3, message = "La direccion del hotel tiene que tener un minimo de 3 caracteres")
    private String direccion;

    @Column(nullable = true)
    @Max(5)
    private Integer numeroDeEstrellas;

    @ElementCollection//(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<String> ruta;

    @ManyToMany(mappedBy = "hoteles", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Caracteristica> caracteristicas;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Comentario> comentarios;

    @ManyToOne
    @ToString.Exclude
    private Ciudad destino;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Habitacion> habitaciones;

    @ManyToOne
    @ToString.Exclude
    private AdministradorHotel administradorHotel;

    public Hotel (String nombre,String direccion, Integer numeroDeEstrellas, Ciudad destino, AdministradorHotel administradorHotel){
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroDeEstrellas = numeroDeEstrellas;
        this.destino = destino;
        this.administradorHotel = administradorHotel;
    }

}
