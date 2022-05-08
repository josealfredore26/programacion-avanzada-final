package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import co.edu.uniquindio.proyecto.Interfaces.HabitacionServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import co.edu.uniquindio.proyecto.Repositorios.HotelRepo;
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
public class HabitacionServicioTest {

    @Autowired
    HabitacionRepo habitacionRepo;

    @Autowired
    HabitacionServicio habitacionServicio;

    @Autowired
    HotelRepo hotelRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarHabitacionTest() {
        try{
            habitacionServicio.agregarHabitacion(hotelRepo.findById(1).get(),150000.0 );
            Assertions.assertEquals(17, habitacionRepo.findById(17).get().getCodigo());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarHabitacionesPorFechasTest() {
        try {
            LocalDate fechaInicio = LocalDate.of(2022, Month.DECEMBER,26);
            LocalDate fechaFinal = LocalDate.of(2023, Month.JANUARY,10);
            habitacionServicio.listarHabitacionesDisponiblesPorFechas(fechaInicio,fechaFinal).forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarHabitacionesTest() {
        try {
            habitacionServicio.listarHabitaciones().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}