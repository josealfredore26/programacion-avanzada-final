
package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Interfaces.ReservaServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import co.edu.uniquindio.proyecto.Repositorios.ReservaRepo;
import co.edu.uniquindio.proyecto.Repositorios.SillaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ReservaServicioTest {

    @Autowired
    ReservaRepo reservaRepo;

    @Autowired
    ReservaServicio reservaServicio;

    @Autowired
    SillaRepo sillaRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    HabitacionRepo habitacionRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarReservaTest()  {
        try {
            List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            habitaciones.add(habitacionRepo.getById(1));
            List<Silla> sillas = new ArrayList<Silla>();
            sillas.add(sillaRepo.getById(1));
            sillas.add(sillaRepo.getById(2));
            sillas.add(sillaRepo.getById(3));
            sillas.add(sillaRepo.getById(4));
            LocalDate fechaInicio = LocalDate.of(2022, Month.APRIL,26);
            LocalDate fechaFinal = LocalDate.of(2022, Month.APRIL,30);
            Reserva reserva = reservaServicio.agregarReserva(fechaInicio, fechaFinal,4,sillas,habitaciones,clienteRepo.findById("1000000001").get());
            reservaServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals(4, reserva.getCantidadDeClientes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarReservaTest() {
        try {
            List<Habitacion> habitaciones = new ArrayList<Habitacion>();
            habitaciones.add(habitacionRepo.getById(1));
            List<Silla> sillas = new ArrayList<Silla>();
            sillas.add(sillaRepo.getById(1));
            sillas.add(sillaRepo.getById(2));
            sillas.add(sillaRepo.getById(3));
            sillas.add(sillaRepo.getById(4));
            LocalDate fechaInicio = LocalDate.of(2022, Month.DECEMBER,26);
            LocalDate fechaFinal = LocalDate.of(2023, Month.JANUARY,10);
            Reserva reserva = reservaServicio.actualizarReserva(1,fechaInicio, fechaFinal,4,sillas,habitaciones,clienteRepo.findById("1000000001").get());
            reservaServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals(4, reserva.getCantidadDeClientes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarReservaTest() {
        try {
            reservaServicio.eliminarReserva(1);
            reservaServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertNull(reservaRepo.findById(1).orElse(null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarReservaPorCodigoTest() {
        try {
            System.out.println(reservaServicio.buscarReservaPorCodigo(1));
            Assertions.assertEquals(1, reservaRepo.findById(1).get().getCantidadDeClientes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest() {
        try {
            reservaServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarReservaPorFechaDeInicioTest()  {
        try {
            LocalDate fechaInicio = LocalDate.of(2022, Month.APRIL,26);
            reservaServicio.listarReservaPorFechaDeFinalizacion(fechaInicio).forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarReservaPorFechaDeFinalizacionTest() {
        try {
            LocalDate fechaFinal = LocalDate.of(2022, Month.APRIL,30);
            reservaServicio.listarReservaPorFechaDeFinalizacion(fechaFinal).forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarReservaPorIdDeClienteTest() {
        try {
            reservaServicio.listarReservaPorIdDeCliente("1000000001").forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void enviarCorreoConInformacionDeLaReservaTest() {
        try {
            reservaServicio.enviarCorreoConInformacionDeLaReserva("josea.ramireze@uqvirtual.edu.co",reservaRepo.findById(1).get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarReservaPorHabitacionTest() {
        try {
            reservaServicio.listarReservaPorHabitacion(habitacionRepo.getById(2)).forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}