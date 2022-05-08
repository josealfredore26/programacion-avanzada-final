package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.SillaServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.SillaRepo;
import co.edu.uniquindio.proyecto.Repositorios.VueloRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class SillaServicioTest {

    @Autowired
    SillaServicio sillaServicio;

    @Autowired
    SillaRepo sillaRepo;

    @Autowired
    VueloRepo vueloRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarSillaTest()  {
        try {
            Vuelo vuelo = vueloRepo.getById(1);
            sillaServicio.agregarSilla(15000.0,true,vuelo);
            Assertions.assertEquals(1, sillaRepo.findById(1).get().getNumero());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void verificarExistenciaDeNumero() {
        try {
            Vuelo vuelo = vueloRepo.getById(5);
            System.out.println(sillaServicio.verificarExistenciaDeNumero(vuelo,10));
            Assertions.assertTrue(sillaServicio.verificarExistenciaDeNumero(vuelo,10));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:datos.sql")
    public void listarPorVuelo() {
        try {
            Vuelo vuelo = vueloRepo.getById(5);
            sillaServicio.listarPorVuelo(vuelo).forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}