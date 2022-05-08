package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface VueloServicio {

    Vuelo agregarVuelo (Ciudad origen, Ciudad destino, Integer cantidadDeSillas, LocalDate fecha) throws Exception;

    Vuelo actualizarVuelo (Integer codigo, Ciudad origenNuevo, Ciudad destinoNuevo, Integer cantidadDeSillasNuevo, LocalDate fechaNueva) throws Exception;

    boolean eliminarVuelo (Integer codigo) throws Exception;

    Vuelo buscarVueloPorCodigo (Integer codigo) throws Exception;

    List<Vuelo> buscarVueloPorOrigen (String origen) throws Exception;

    List<Vuelo> buscarVueloPorDestino (String destino) throws Exception;

    List<Vuelo> buscarVueloPorFecha (LocalDate fecha) throws Exception;

    List<Vuelo> listar();

}
