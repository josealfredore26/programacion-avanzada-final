package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.HabitacionServicio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

public class HabitacionConverter implements Converter<Habitacion> , Serializable {

    @Autowired
    private HabitacionServicio habitacionServicio;

    @Override
    public Habitacion getAsObject(FacesContext context, UIComponent component, String habitacion) {
        Habitacion habitacion1 = null;
        try {
//            habitacion1 = habitacionServicio.(Integer.valueOf(valorVuelo));
            return habitacion1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Habitacion habitacion) {
        if (habitacion!= null){
            return String.valueOf(habitacion.getCodigo());
        }
        return "";            }

}
