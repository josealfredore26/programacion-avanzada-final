package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Caracteristica;

import java.util.ArrayList;
import java.util.List;

public interface CaracteristicaServicio {

    Caracteristica agregarCaracteristica (String contenido) throws Exception;

    Caracteristica actualizarCaracteristica (Integer codigo, String contenido) throws Exception;

    boolean eliminarCaracteristica (Integer codigo) throws Exception;

    Caracteristica buscarCaracteristica (Integer codigo) throws Exception;

    List<Caracteristica> buscarCaracteristicasPorContenido (String contenido) throws Exception;

    List<Caracteristica> listar() throws Exception;
}
