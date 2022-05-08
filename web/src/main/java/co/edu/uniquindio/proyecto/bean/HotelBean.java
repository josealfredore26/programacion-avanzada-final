package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Interfaces.AdministradorHotelServicio;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Interfaces.HotelServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class HotelBean implements Serializable {

    @Autowired
    private HotelServicio hotelServicio;

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Autowired
    private CiudadServicio ciudadServicio;

    private String nombre;

    private String dirrecion;

    private Integer numEstrellas;

    private List<Ciudad> ciudades;

    private Ciudad ciudadHotel;

    private List<AdministradorHotel> administradorHotels;

    private AdministradorHotel administradorHotel;

    @PostConstruct
    public void inicializar(){
        this.ciudades = ciudadServicio.listar();
        this.administradorHotels = administradorHotelServicio.listar();
    }

    public void registrarHotel(){
        try {
            hotelServicio.agregarHotel(nombre,dirrecion,numEstrellas,ciudadHotel,administradorHotel);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"alerta", "registro exitoso");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }
    }


}
