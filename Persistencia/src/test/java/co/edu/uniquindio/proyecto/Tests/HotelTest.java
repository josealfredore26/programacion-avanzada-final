package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Hotel;
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
public class HotelTest {

    @Autowired
    private HotelRepo hotelRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarHotel(){

        Hotel hotel = new Hotel();
        Integer codigo,numeroEstrellas;
        String  nombre, direccion;
        numeroEstrellas = 4;
        nombre = "Abel Antonio";
        direccion = "cr 19 25N-50";
        hotel.setNumeroDeEstrellas(numeroEstrellas);
        hotel.setNombre(nombre);
        hotel.setDireccion(direccion);
        hotelRepo.save(hotel);
        Assertions.assertEquals("Abel Antonio", hotelRepo.findById(5).get().getNombre());

        List<Hotel> lista = hotelRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }


    @Test
    @Sql("classpath:datos.sql")
    public void actualizarHotel(){

        Hotel hotelBuscar = hotelRepo.findById(1).orElse(null);

        hotelBuscar.setNombre("hotel lozano");

        hotelRepo.save(hotelBuscar);

        List<Hotel> lista = hotelRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarHotel(){

        hotelRepo.deleteById(2);
        Assertions.assertNull(hotelRepo.findById(2).orElse(null));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarHotel(){

        hotelRepo.findById(1);
        Assertions.assertEquals("Hotel Ciudad Fria",  hotelRepo.findById(1).orElse(null).getNombre());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarHotel(){

        List<Hotel> lista = hotelRepo.findAll();

        lista.forEach(u -> System.out.println(u));
    }

}
