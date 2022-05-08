package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.Interfaces.CaracteristicaServicio;
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
public class CaracteristicaBean implements Serializable {

    @Autowired
    CaracteristicaServicio caracteristicaServicio;

    private String contenido;

    public void IngresarCaracteristica(){
        try {
            caracteristicaServicio.agregarCaracteristica(contenido);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "alerta", "Caracteristica agregada");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }catch (Exception e){
            e.printStackTrace();
            e.printStackTrace();
            FacesMessage msg1 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg1);
        }
    }


}
