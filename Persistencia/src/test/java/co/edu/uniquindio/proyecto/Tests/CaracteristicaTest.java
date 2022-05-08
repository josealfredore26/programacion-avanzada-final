package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Caracteristica;
import co.edu.uniquindio.proyecto.Repositorios.CaracteristicaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaracteristicaTest {

    @Autowired
    private CaracteristicaRepo caracteristicaRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarCaracteristica(){

        Caracteristica caracteristica = new Caracteristica();
        String  contenido;
        contenido = "Sala de juegos gammer";
        caracteristica.setContenido(contenido);
        caracteristicaRepo.save(caracteristica);
        Assertions.assertEquals("Sala de juegos gammer", caracteristicaRepo.findById(6).get().getContenido());

        List<Caracteristica> lista = caracteristicaRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }


    @Test
    @Sql("classpath:datos.sql")
    public void actualizarCaracteristica(){

        Caracteristica caracteristicaBuscar = caracteristicaRepo.findById(1).orElse(null);

        caracteristicaBuscar.setContenido("hotel lozano");

        caracteristicaRepo.save(caracteristicaBuscar);

        List<Caracteristica> lista = caracteristicaRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarCaracteristica(){

        caracteristicaRepo.deleteById(2);
        Assertions.assertNull(caracteristicaRepo.findById(2).orElse(null));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarCCaracteristica(){

        caracteristicaRepo.findById(1);
        Assertions.assertEquals("Piscina",  caracteristicaRepo.findById(1).orElse(null).getContenido());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarCaracteristica(){

        List<Caracteristica> lista = caracteristicaRepo.findAll();

        lista.forEach(u -> System.out.println(u));
    }


}
