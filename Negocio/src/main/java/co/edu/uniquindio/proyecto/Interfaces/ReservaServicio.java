package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface ReservaServicio {

    Reserva agregarReserva (LocalDate fechaInicio, LocalDate fechaFinal, Integer cantidadDeClientes, List<Silla> sillas, List<Habitacion> habitaciones, Cliente cliente) throws Exception;

    Reserva actualizarReserva (Integer codigo, LocalDate fechaInicio, LocalDate fechaFinal, Integer cantidadDeClientes, List<Silla> sillas, List<Habitacion> habitaciones, Cliente cliente) throws Exception;

    boolean eliminarReserva (Integer codigo) throws Exception;

    Reserva buscarReservaPorCodigo (Integer codigo) throws Exception;

    List<Reserva> listar() throws Exception;

    List<Reserva> listarReservaPorFechaDeInicio (LocalDate fechaInicio) throws Exception;

    List<Reserva> listarReservaPorFechaDeFinalizacion (LocalDate fechaFinal) throws Exception;

    List<Reserva> listarReservaPorIdDeCliente (String cedula) throws Exception;

    public boolean enviarCorreoConInformacionDeLaReserva(String email, Reserva reserva) throws Exception;

    List<Reserva> listarReservaPorHabitacion(Habitacion habitacion) throws Exception;

}
