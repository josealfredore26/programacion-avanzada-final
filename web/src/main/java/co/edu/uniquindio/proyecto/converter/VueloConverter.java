package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.VueloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class VueloConverter implements Converter<Vuelo> , Serializable {

    @Autowired
    private VueloServicio vueloServicio;

    @Override
    public Vuelo getAsObject(FacesContext context, UIComponent component, String valorVuelo) {
        Vuelo vuelo = null;
        try {
            vuelo = vueloServicio.buscarVueloPorCodigo(Integer.valueOf(valorVuelo));
            return vuelo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Vuelo vuelo) {
        if (vuelo!= null){
            return String.valueOf(vuelo.getCodigo());
        }
        return "";    }

}
