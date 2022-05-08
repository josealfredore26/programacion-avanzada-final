package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.SillaServicio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

public class SillaConverter implements Converter<Silla>, Serializable {

    @Autowired
    private SillaServicio sillaServicio;

    @Override
    public Silla getAsObject(FacesContext context, UIComponent component, String Silla) {
        Silla silla = null;
        try {
//            silla = sillaServicio.(Integer.valueOf(Silla));
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Silla silla) {
        if (silla!= null){
            return String.valueOf(silla.getCodigo());
        }
        return "";        }

}
