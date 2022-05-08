package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Interfaces.ClienteServicio;
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
@Getter @Setter
public class RegistrarClienteBean implements Serializable {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private CiudadServicio ciudadServicio;

    private String cedula;

    private String nombre;

    private String email;

    private String password;

    private List<Ciudad> ciudades;

    private Ciudad ciudad;

    private List<String> telefonos;

    private String numero;

    @PostConstruct
    public void inicializar(){
        this.ciudades = ciudadServicio.listar();
        this.telefonos = new ArrayList<String>();
    }

    public String registrarCliente(){
        try {
            clienteServicio.registrarCliente(cedula,nombre,email,password,ciudad,telefonos);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta", "Registro Exitoso!");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
            telefonos.clear();
            cedula=nombre=email=password="";
            ciudad=null;
            if(ciudad==null){
                return "RegistrarCliente.xhtml?faces-redirect=true";
            }
        }catch (Exception e){
            e.printStackTrace();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }
        return null;
    }

    public void agregarNumeroDeTelefono(){
        boolean centinela = verificarNumero();
        boolean centinela2 = false;
        if(centinela){
            if(telefonos.isEmpty()){
                telefonos.add(numero);
            } else{
                for (int i = 0; i < telefonos.size(); i++) {
                    if(numero.equalsIgnoreCase(telefonos.get(i))){
                        System.out.println("ERROR: Ya existe ese numero en el listado!");
                        centinela2 = true;
                        break;
                    }
                }
                if(!centinela2){
                    telefonos.add(numero);
                }
            }
        }
    }

    public boolean verificarNumero(){
        boolean centinela = false;
            boolean existenciaDeNumeroEnBD = clienteServicio.verificarNumeroEnListadoDeTelefonos(numero);
            if(!numero.isBlank()) {
                for(int i = 0; i < numero.length(); i++){
                    if(!Character.isDigit(numero.charAt(i))) {
                        centinela = true;
                    }
                }
                if(centinela == false) {
                    if(existenciaDeNumeroEnBD){
                        System.out.println("ERROR: El numero ya existe en la base de datos");
                    } else{
                        return true;
                    }
                } else {
                    System.out.println("ERROR: Lo ingresado no es un numero!");
                }
            } else {
                System.out.println("ERROR: No ha escrito nada en el campo.");
            }
        return false;
    }


}
