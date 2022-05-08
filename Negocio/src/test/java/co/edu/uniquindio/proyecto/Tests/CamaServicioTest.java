package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Interfaces.CamaServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.CamaRepo;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static co.edu.uniquindio.proyecto.Entidades.TipoCama.SENCILLA;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CamaServicioTest {

    @Autowired
    CamaRepo camaRepo;

    @Autowired
    CamaServicio camaServicio;

    @Autowired
    HabitacionRepo habitacionRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarCamaTest() {
        try{
            camaServicio.agregarCama(habitacionRepo.findById(1).get(), SENCILLA );
            Assertions.assertEquals(habitacionRepo.findById(1).get(), camaRepo.findById(6).get().getHabitacion());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}