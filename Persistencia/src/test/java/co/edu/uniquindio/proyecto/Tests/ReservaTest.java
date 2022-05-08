package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.*;
import co.edu.uniquindio.proyecto.Repositorios.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservaTest {

    @Autowired
    private ReservaRepo reservaRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private VueloRepo vueloRepo;

    @Autowired
    private SillaRepo sillaRepo;

    @Autowired
    private HabitacionRepo habitacionRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void crearTest() {

        List<Reserva> lista = reservaRepo.findAll();
        lista.forEach(u -> System.out.println(u));

        Reserva reserva = new Reserva();
        reserva.setCostoTotal(300000.0);
        reserva.setCantidadDeClientes(3);
        reserva.setFechaFinal(LocalDate.of(2022, 04, 29));
        reserva.setFechaInicio(LocalDate.of(2022, 04, 30));
        reserva.setCliente(clienteRepo.getById("1000000001"));
        reserva.setVuelo(vueloRepo.getById(1));
        ArrayList<Habitacion> list = new ArrayList<Habitacion>();
        System.out.println(habitacionRepo.getById(1));
        list.add(habitacionRepo.getById(1));
        reserva.setHabitaciones(list);

        reservaRepo.save(reserva);

        lista = reservaRepo.findAll();
        lista.forEach(u -> System.out.println(u + u.getHabitaciones().toString()));


    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        Reserva reserva = reservaRepo.getById(1);
        System.out.println(reserva);

    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {

        Reserva reserva = reservaRepo.getById(1);
        System.out.println(reserva);

        reserva.setCantidadDeClientes(4);
        reservaRepo.save(reserva);

        reserva = reservaRepo.getById(1);

        System.out.println(reserva);

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {

        List<Reserva> lista = reservaRepo.findAll();
        lista.forEach(u -> System.out.println(u));

        List<Silla> listadoSillasReserva = sillaRepo.findAll();

        reservaRepo.deleteById(1);

        lista = reservaRepo.findAll();
        if (lista.isEmpty()) {
            System.out.println("No hay registro de reservas.");
        } else {
            lista.forEach(u -> System.out.println(u));
        }

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest() {

        List<Reserva> lista = reservaRepo.findAll();
        lista.forEach(u -> System.out.println(u));

    }

}
