package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class CiudadServicioImpl {

    @Autowired
    CiudadRepo ciudadRepo;

    @Autowired
    CiudadServicio ciudadServicio;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarCiudadTest()  {
        try {
            ciudadServicio.agregarCiudad("Armenia");
            ciudadServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Armenia", ciudadRepo.buscarPorNombre("Armenia").get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarCiudadTest()  {
        try {
            ciudadServicio.actualizarCiudad(1,"Armenia");
            ciudadServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Armenia", ciudadRepo.findById(1).get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarCiudadTest()  {
        try {
            boolean aux = ciudadServicio.eliminarCiudad(1);
            ciudadServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertNull(ciudadRepo.findById(1).orElse(null));
            System.out.println(aux);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarCiudadTest()  {
        try {
            System.out.println(ciudadServicio.buscarCiudad("Bogota"));
            Assertions.assertEquals("Bogota", ciudadRepo.findById(1).get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest()  {
        try {
            ciudadServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}