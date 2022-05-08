package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.Repositorios.VueloRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloTest {

    @Autowired
    private VueloRepo vueloRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarVuelo(){

        Vuelo vuelo = new Vuelo();

        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);

        Ciudad ciudad1 = ciudadRepo.findById(2).orElse(null);

        vuelo.setDestino(ciudad);

        vuelo.setOrigen(ciudad1);

        System.out.println("Ciudad destino: " + ciudad + "\nCiudad origen: " + ciudad1);

        vuelo.setCantidadDeSillas(10);

        vueloRepo.save(vuelo);

        Assertions.assertEquals(ciudad, vueloRepo.findById(1).get().getDestino());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void ActualizarVuelo(){

        Vuelo vueloBuscar = vueloRepo.findById(1).orElse(null);

        Ciudad ciudadBuscar = ciudadRepo.findById(1).orElse(null);

        vueloBuscar.setDestino(ciudadBuscar);

        vueloRepo.save(vueloBuscar);

        List<Vuelo> lista = vueloRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarVuelo(){

        vueloRepo.deleteById(2);
        Assertions.assertNull(vueloRepo.findById(2).orElse(null));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarVuelo(){

        vueloRepo.findById(1);
        Assertions.assertEquals(1,  vueloRepo.findById(1).orElse(null).getCodigo());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarVuelo(){

        List<Vuelo> lista = vueloRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

}
