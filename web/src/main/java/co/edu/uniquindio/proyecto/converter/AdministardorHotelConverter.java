package co.edu.uniquindio.proyecto.converter;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Interfaces.AdministradorHotelServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

@Component
public class AdministardorHotelConverter implements Converter<AdministradorHotel>, Serializable {

    @Autowired
    private AdministradorHotelServicio administradorHotelServicio;

    @Override
    public AdministradorHotel getAsObject(FacesContext context, UIComponent component, String value) {
        AdministradorHotel administradorHotel = null;
        try {
            administradorHotel = administradorHotelServicio.buscarAdministradorDeHotelPorCodigo(Integer.valueOf(value));
            return administradorHotel;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, AdministradorHotel administradorHotel) {
        if (administradorHotel != null){
            return String.valueOf(administradorHotel.getCodigo());
        }
        return "";
    }

}
