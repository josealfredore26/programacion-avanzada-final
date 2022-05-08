package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.Interfaces.AdministradorHotelServicio;
import co.edu.uniquindio.proyecto.Interfaces.AdministradorServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
@Getter
@Setter
public class AdministradorHotelBean implements Serializable {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    private String cedula;

    private String nombre;

    private String email;

    private String password;


    public void registrarAdministradorHotel(){
        try {
            administradorHotelServicio.agregarAdministradorDeHotel(cedula,nombre,email,password);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"alerta", "registro exitoso");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }
    }


}
