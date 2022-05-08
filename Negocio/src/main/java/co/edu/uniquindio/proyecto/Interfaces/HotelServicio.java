package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Hotel;

import java.util.ArrayList;
import java.util.List;

public interface HotelServicio {

    Hotel agregarHotel (String nombre, String direccion, Integer numeroDeEstrellas, Ciudad ciudad, AdministradorHotel administradorHotel) throws Exception;

    Hotel actualizarHotel (Integer codigo, String nombre, String direccion, Integer numeroDeEstrellas, Ciudad ciudad, AdministradorHotel administradorHotel) throws Exception;

    boolean eliminarHotel (Integer codigo) throws Exception;

    List<Hotel> buscarHotelPorNombre (String nombre) throws Exception;

    Hotel buscarHotelPorCodigo (Integer codigo) throws Exception;

    List<Hotel> listar() throws Exception;

    List<Hotel> listarHotelPorCiudad (String nombreCiudad) throws Exception;

}
