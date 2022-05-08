package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;

import java.util.List;

public interface CiudadServicio {

    Ciudad agregarCiudad (String nombre) throws Exception;

    Ciudad actualizarCiudad (Integer codigo, String nombreNuevo) throws Exception;

    boolean eliminarCiudad (Integer codigo) throws Exception;

    List<Ciudad> buscarCiudad (String nombre) throws Exception;

    List<Ciudad> listar();

    Ciudad obtenerCuidad(Integer id) throws Exception;

}
