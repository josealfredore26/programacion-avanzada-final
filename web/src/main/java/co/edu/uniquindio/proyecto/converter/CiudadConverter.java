package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class CiudadConverter implements Converter<Ciudad>, Serializable {

    @Autowired
    private CiudadServicio ciudadServicio;

    @Override
    public Ciudad getAsObject(FacesContext context, UIComponent component, String value) {
        Ciudad ciudad = null;
        try {
            ciudad = ciudadServicio.obtenerCuidad(Integer.valueOf(value));
            return ciudad;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Ciudad ciudad) {
        if (ciudad != null){
            return String.valueOf(ciudad.getCodigo());
        }
        return "";
    }
}
