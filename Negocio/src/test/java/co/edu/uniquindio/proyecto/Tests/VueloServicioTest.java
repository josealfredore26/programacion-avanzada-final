package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Interfaces.SillaServicio;
import co.edu.uniquindio.proyecto.Interfaces.VueloServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.VueloRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class VueloServicioTest {

    @Autowired
    VueloServicio vueloServicio;

    @Autowired
    SillaServicio sillaServicio;

    @Autowired
    VueloRepo vueloRepo;

    @Autowired
    CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarVueloTest() {
        try{
            Vuelo aux = vueloServicio.agregarVuelo(ciudadRepo.getById(1), ciudadRepo.getById(2), 30, LocalDate.now());
            vueloServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals(30, aux.getCantidadDeSillas());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarVueloTest() {
        try{
            vueloServicio.actualizarVuelo(1,ciudadRepo.getById(1),ciudadRepo.getById(2),21,LocalDate.now());
            vueloServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals(21, vueloRepo.findById(1).get().getCantidadDeSillas());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarVueloTest() {
        try{
            System.out.println(vueloServicio.eliminarVuelo(1));
            vueloServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertNull(vueloRepo.findById(1).orElse(null));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarVueloPorCodigoTest() {
        try{
            System.out.println(vueloServicio.buscarVueloPorCodigo(1));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarVueloPorOrigenTest() {
        try{
            System.out.println(vueloServicio.buscarVueloPorOrigen(ciudadRepo.getById(1).getNombre()));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarVueloPorDestinoTest() {
        try{
            System.out.println(vueloServicio.buscarVueloPorDestino(ciudadRepo.getById(1).getNombre()));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarVueloPorFechaTest() {
        try{
            LocalDate fecha = LocalDate.of(2022, Month.DECEMBER,05);
            System.out.println(vueloServicio.buscarVueloPorFecha(fecha));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest()  {
        try{
            vueloServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
