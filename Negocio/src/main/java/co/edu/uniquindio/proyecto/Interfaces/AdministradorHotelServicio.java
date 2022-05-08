package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;

import java.util.List;

public interface AdministradorHotelServicio {

    AdministradorHotel login (String email, String password) throws Exception;

    AdministradorHotel agregarAdministradorDeHotel (String cedula, String nombre, String email, String password) throws Exception;

    AdministradorHotel actualizarAdministradorDeHotel (String cedula, String nombre,  String email, String password, Integer codigo) throws Exception;

    boolean eliminarAdministradorDeHotelPorCedula (String cedula) throws Exception;

    AdministradorHotel buscarAdministradorDeHotelPorCedula (String cedula) throws Exception;

    AdministradorHotel buscarAdministradorDeHotelPorCodigo (Integer codigo) throws Exception;

    AdministradorHotel buscarAdministradorDeHotelPorHotel (Integer codigo) throws Exception;

    List<AdministradorHotel> listar();
}
