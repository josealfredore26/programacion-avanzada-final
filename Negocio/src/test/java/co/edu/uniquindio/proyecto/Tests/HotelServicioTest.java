package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Interfaces.HotelServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorHotelRepo;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class HotelServicioTest {

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    HotelServicio hotelServicio;

    @Autowired
    CiudadRepo ciudadRepo;

    @Autowired
    AdministradorHotelRepo administradorHotelRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarHotelTest() {
        try {
            hotelServicio.agregarHotel("La santidad de dios","cra 19-68N55",5,ciudadRepo.getById(1),administradorHotelRepo.getById("2345678901"));
            hotelServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("La santidad de dios", hotelRepo.findByNombre("La santidad de dios").get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarHotelTest()  {
        try {
            hotelServicio.actualizarHotel(1,"Hotel Ciudad Fria","cra 19-68N55",4,ciudadRepo.getById(1),administradorHotelRepo.getById("2345678901"));
            hotelServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("cra 19-68N55", hotelRepo.findByNombre("Hotel Ciudad Fria").get().getDireccion());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarHotelTest() {
        try {
            hotelServicio.eliminarHotel(1);
            hotelServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertNull(hotelRepo.findById(1).orElse(null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarHotelPorNombreTest()  {
        try {
            System.out.println(hotelServicio.buscarHotelPorNombre("Hotel Ciudad Fria"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarHotelPorCodigoTest()  {
        try {
            System.out.println(hotelServicio.buscarHotelPorCodigo(2));
            Assertions.assertEquals("Hotel Ciudad De Las Luces", hotelServicio.buscarHotelPorCodigo(2).getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest()  {
        try {
            hotelServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarHotelPorCiudadTest()  {
        try {
            hotelServicio.listarHotelPorCiudad("Bogota").forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
