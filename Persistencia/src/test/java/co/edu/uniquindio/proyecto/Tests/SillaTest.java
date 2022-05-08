package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Repositorios.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SillaTest {

    @Autowired
    private SillaRepo sillaRepo;

    @Autowired
    private  VueloRepo vueloRepo;

    @Autowired
    private ReservaRepo reservaRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarSilla(){

        Silla silla = new Silla();

        Reserva reserva = reservaRepo.findById(1).orElse(null);

        Vuelo vuelo = vueloRepo.findById(1).orElse(null);

        Integer numero;
        Double valor;
        Boolean disponibilidad;

        numero = 12;
        valor = 124000.00;
        disponibilidad = true;

        silla.setNumero(numero);
        silla.setValor(valor);
        silla.setDisponibilidad(disponibilidad);
        silla.setVuelo(vuelo);

        sillaRepo.save(silla);

        Assertions.assertEquals(numero, sillaRepo.findById(51).get().getNumero());

        List<Silla> lista = sillaRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void ActualizarSilla(){

        Silla silla = sillaRepo.findById(1).orElse(null);

        silla.setNumero(12);

        sillaRepo.save(silla);

        List<Silla> lista = sillaRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarSilla(){

        sillaRepo.deleteById(2);
        Assertions.assertNull(sillaRepo.findById(2).orElse(null));

        List<Silla> lista = sillaRepo.findAll();

        lista.forEach(u -> System.out.println(u));


    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarSilla(){

        sillaRepo.findById(1);
        Assertions.assertEquals(1,  sillaRepo.findById(1).orElse(null).getCodigo());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarSilla(){

        List<Silla> lista = sillaRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }


}
