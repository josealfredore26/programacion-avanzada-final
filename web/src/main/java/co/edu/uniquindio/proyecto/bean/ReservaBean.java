package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.Entidades.Cliente;
import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@Getter
@Setter
public class ReservaBean implements Serializable {

    @Autowired
    private ReservaServicio reservaServicio;

    @Autowired
    private HabitacionServicio habitacionServicio;

    @Autowired
    private SillaServicio sillaServicio;

    @Autowired
    private VueloServicio vueloServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    private LocalDate fecha_inicio;

    private LocalDate fecha_final;

    private Integer cantidad_cliente;

    private List<Silla> sillas;

    private List<Habitacion> habitacions;

    private Cliente cliente;

    private List<Vuelo> vuelos;

    private Vuelo vuelo;

    @PostConstruct
    public void inicializar() throws Exception {
        this.vuelos = vueloServicio.listar();
        this.sillas = sillaServicio.listarPorVuelo(vuelo);
        this.habitacions = habitacionServicio.listarHabitaciones();
    }

    public void agregarReserva(){
        try {
            reservaServicio.agregarReserva(fecha_inicio,fecha_final,cantidad_cliente,sillas,habitacions,cliente);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta", "Registro Exitoso!");
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }catch (Exception e){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("msj-bean", msg);
        }
    }


}
