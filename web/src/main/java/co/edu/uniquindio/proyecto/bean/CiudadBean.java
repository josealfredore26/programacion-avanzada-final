package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class CiudadBean implements Serializable {

    @Autowired
    private CiudadServicio ciudadServicio;

    private List<Ciudad> ciudades;

    private String nombre;

    private String buscar;

    private List<Ciudad> buscadas;

    @PostConstruct
    public void inicializar(){
        this.ciudades = ciudadServicio.listar();
    }

    public String eliminar(Integer id){
        try{
            ciudadServicio.eliminarCiudad(id);
            return "GestionarCiudad.xhtml?faces-redirect=true";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String agregar(){
        try{
            ciudadServicio.agregarCiudad(nombre);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta", "Registro Exitoso!");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
            return "GestionarCiudad.xhtml?faces-redirect=true";
        }catch(Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }
        return null;
    }

    public String llevarParaActualizar(Integer ciudadCodigo){
        return "ActualizarCiudad.xhtml?faces-redirect=true&amp;codigo="+ciudadCodigo;
    }

    public void buscarCiudad(){
        try{
            ciudades = ciudadServicio.buscarCiudad(buscar);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
