package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Comentario;
import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import co.edu.uniquindio.proyecto.Repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HabitacionTest {

    @Autowired
    private HabitacionRepo habitacionRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarHabitacion(){

        Habitacion habitacion = new Habitacion();

        Hotel hotelBuscar = hotelRepo.findById(1).orElse(null);

        Integer numero;
        Double precio;
        numero = 14;
        precio = 100000.00;
        habitacion.setNumero(numero);
        habitacion.setPrecio(precio);
        habitacion.setHotel(hotelBuscar);
        habitacionRepo.save(habitacion);

        Assertions.assertEquals(14, habitacionRepo.findById(17).get().getNumero());

        List<Habitacion> lista = habitacionRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }


    @Test
    @Sql("classpath:datos.sql")
    public void actualizarHabitacion(){

        Habitacion habitacionBuscar = habitacionRepo.findById(1).orElse(null);

        habitacionBuscar.setNumero(20);

        habitacionRepo.save(habitacionBuscar);

        List<Habitacion> lista = habitacionRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarHabitacion(){

        habitacionRepo.deleteById(2);
        Assertions.assertNull(habitacionRepo.findById(2).orElse(null));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarHabitacion(){

        habitacionRepo.findById(1);
        Assertions.assertEquals(1,  habitacionRepo.findById(1).orElse(null).getNumero());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarHabitacion(){

        List<Habitacion> lista = habitacionRepo.findAll();

        lista.forEach(u -> System.out.println(u));
    }



}
