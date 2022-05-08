package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Cama;
import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.TipoCama;
import co.edu.uniquindio.proyecto.Repositorios.CamaRepo;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CamaTest {

    @Autowired
    private CamaRepo camaRepo;

    @Autowired
    private HabitacionRepo habitacionRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void crearTest() {

        Cama cama = new Cama();
        Habitacion habitacion = habitacionRepo.getById(1);
        cama.setNumero(habitacion.getCamas().size()+1);
        cama.setHabitacion(habitacion);
        cama.setTipo(TipoCama.CUADRUPLE);

        camaRepo.save(cama);

        List<Cama> lista = camaRepo.findAll();
        lista.forEach(u -> System.out.println(u));
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        Cama cama = camaRepo.getById(3);

        System.out.println("Numero de habitacion: " + cama.getHabitacion().getNumero());

        System.out.println("Numero de cama: " + cama.getNumero());

        System.out.println(cama.getTipo());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {

        Cama cama = camaRepo.getById(3);

        System.out.println("Numero de habitacion: " + cama.getHabitacion().getNumero());

        System.out.println("Numero de cama: " + cama.getNumero());

        System.out.println(cama.getTipo());

        cama.setTipo(TipoCama.CUADRUPLE);

        camaRepo.save(cama);

        System.out.println("Numero de habitacion: " + cama.getHabitacion().getNumero());

        System.out.println("Numero de cama: " + cama.getNumero());

        System.out.println(cama.getTipo());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {

        List<Cama> lista = camaRepo.findAll();
        lista.forEach(u -> System.out.println(u));

        camaRepo.deleteById(3);

        lista = camaRepo.findAll();
        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest() {

        List<Cama> lista = camaRepo.findAll();
        lista.forEach(u -> System.out.println(u));

    }

}
