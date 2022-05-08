package co.edu.uniquindio.proyecto.Entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@AllArgsConstructor
public class Persona implements Serializable {

         /*
     Clase Persona
     Esta pose un codigo,un nombre,una email y una password
     Las variables listadas aqui no se pueden dejar en null
     */

    @Id
    @EqualsAndHashCode.Include
    @NotBlank
    @Length(min=10, max=10,message ="La cedula debe tener 10 caracteres.")
    private String cedula;

    @Column(nullable = false)
    @Length(min=3, max=15,message ="El nombre debe tener entre 3 y 15 caracteres.")
    @NotBlank
    private String nombre;

    @Column(nullable = false,unique = true,length = 150)
    @Length(min=10,max = 150,message = "El email debe tener entre 10 y 150 caracteres.")
    @NotBlank
    @Email
    private String email;

    @Column(nullable = false)
    @NotBlank
    @Length(min=5, max=15,message ="la contraseña  debe tener entre 5 y 10 caracteres.")
    private String password;

}
