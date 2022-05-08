package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class ActualizarCiudadBean implements Serializable {

    @Autowired
    private CiudadServicio ciudadServicio;


    private Ciudad ciudad;

    private String nombre;

    @Value("#{param['codigo']}")
    private Integer codigo;

    private List<Ciudad> ciudades;

    @PostConstruct
    public void inicializar(){
        this.ciudades = new ArrayList<Ciudad>();
        try{
            this.ciudad = ciudadServicio.obtenerCuidad(codigo);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.ciudades.add(ciudad);
    }

    public String actualizar(){
        try{
            ciudadServicio.actualizarCiudad(ciudad.getCodigo(), nombre);
            return "GestionarCiudad.xhtml?faces-redirect=true";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
