package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepo extends JpaRepository<Reserva,Integer> {

    List<Reserva> findAllByFechaInicio(LocalDate fechaInicio);

    List<Reserva> findAllByFechaFinal(LocalDate fechaFinal);

    @Query("select r from Reserva r where r.cliente.cedula = :cedula")
    List<Reserva> listarReservaPorIdDeCliente(String cedula);

    @Query("select r from Reserva r where r.fechaInicio = :fecha")
    List<Reserva> listarReservaPorFechaInicio(LocalDate fecha);

    @Query("select r from Reserva r where r.fechaFinal = :fecha")
    List<Reserva> listarReservaPorFechaFinal(LocalDate fecha);

    @Query("select r from Reserva r join r.habitaciones h where h.codigo = :habitacionCodigo")
    List<Reserva> listarReservaPorHabitacion(Integer habitacionCodigo);

    @Query("select r from Reserva r where (r.fechaFinal < :entrada) or (r.fechaInicio > :salida)")
    List<Reserva> listarReservasConVerificacionDeFechas(LocalDate entrada, LocalDate salida);

    List<Reserva> findByFechaInicio(LocalDate fechaInicio);

}
