package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.Cama;
import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.TipoCama;

public interface CamaServicio {

    Cama agregarCama (Habitacion habitacion, TipoCama tipo) throws Exception;

}
