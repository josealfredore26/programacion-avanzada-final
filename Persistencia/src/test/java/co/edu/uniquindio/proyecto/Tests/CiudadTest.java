package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Administrador;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CiudadTest {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarVuelo(){

        Ciudad ciudad = new Ciudad();

        String  nombre;
        nombre = "Jamaica";

        ciudad.setNombre(nombre);

        ciudadRepo.save(ciudad);

        Assertions.assertEquals("Jamaica", ciudadRepo.findById(5).get().getNombre());


        List<Ciudad> lista = ciudadRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void ActualizarVuelo(){

        Ciudad ciudadBuscar = ciudadRepo.findById(1).orElse(null);

        ciudadBuscar.setNombre("Armenia");

        ciudadRepo.save(ciudadBuscar);

        List<Ciudad> lista = ciudadRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarHotel(){

        ciudadRepo.deleteById(2);
        Assertions.assertNull(ciudadRepo.findById(2).orElse(null));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {
        ciudadRepo.findById(1).orElse(null);
        Assertions.assertEquals("Bogota", ciudadRepo.findById(1).orElse(null).getNombre());
    }

}
