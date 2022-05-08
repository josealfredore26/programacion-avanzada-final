package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Interfaces.CaracteristicaServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.CaracteristicaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CaracteristicasServicioTest {

    @Autowired
    CaracteristicaRepo caracteristicaRepo;

    @Autowired
    CaracteristicaServicio caracteristicaServicio;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarCaracteristicaTest()  {
        try {
            caracteristicaServicio.agregarCaracteristica("Video juegos");
            caracteristicaServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Video juegos", caracteristicaRepo.findByContenido("Video juegos").get().getContenido());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarCaracteristicaTest()  {
        try {
            caracteristicaServicio.actualizarCaracteristica(2,"Salon recreativo");
            caracteristicaServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Salon recreativo", caracteristicaRepo.findById(2).get().getContenido());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarCaracteristicaTest()  {
        try {
            caracteristicaServicio.eliminarCaracteristica(3);
            caracteristicaServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertNull(caracteristicaRepo.findById(3).orElse(null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarCaracteristicaTest()  {
        try {
            System.out.println(caracteristicaServicio.buscarCaracteristica(4));
            Assertions.assertEquals("Balcon", caracteristicaServicio.buscarCaracteristica(4).getContenido());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarCaracteristicasPorContenidoTest()  {
        try {
            System.out.println(caracteristicaServicio.buscarCaracteristicasPorContenido("Aire acondicionado"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest()  {
        try {
            caracteristicaServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}