package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Interfaces.AdministradorHotelServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorHotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class AdministradorHotelServicioTest {

    @Autowired
    AdministradorHotelRepo administradorHotelRepo;

    @Autowired
    AdministradorHotelServicio administradorHotelServicio;

    @Test
    @Sql("classpath:datos.sql")
    public void loginTest(){
        try {
            administradorHotelServicio.login("administradorHotel2@email.com","julio123");
            System.out.println("Ingreso exitoso");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:datos.sql")
    public void agregarAdministradorDeHotelTest(){
        try {
            administradorHotelServicio.agregarAdministradorDeHotel("1004961210","Pablo andres","pablitoal157@gmail.com","pabl124");
            administradorHotelServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Pablo andres", administradorHotelRepo.findById("1004961210").get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarAdministradorDeHotelTest(){
        try {
            administradorHotelServicio.actualizarAdministradorDeHotel("2345678901","Pablo andres","pablitoal15@gmail.com","pabl124",9);
            administradorHotelServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Pablo andres", administradorHotelRepo.findById("2345678901").get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarAdministradorDeHotelPorCedulaTest(){
        try {
            administradorHotelServicio.eliminarAdministradorDeHotelPorCedula("2345678901");
            administradorHotelServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertNull(administradorHotelRepo.findById("2345678901").orElse(null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarAdministradorDeHotelPorCedulaTest(){
        try {
            System.out.println(administradorHotelServicio.buscarAdministradorDeHotelPorCedula("2345678901"));
            Assertions.assertEquals("Nicolas Mendoza", administradorHotelRepo.findById("2345678901").get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarAdministradorDeHotelPorCodigoTest(){
        try {
            System.out.println(administradorHotelServicio.buscarAdministradorDeHotelPorCodigo(95));
            Assertions.assertEquals("Nicolas Mendoza", administradorHotelRepo.findByCodigo(95).get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarAdministradorDeHotelPorHotel(){
        try {
            System.out.println(administradorHotelServicio.buscarAdministradorDeHotelPorHotel(1));
            Assertions.assertEquals("Nicolas Mendoza", administradorHotelRepo.buscarPorCodigoDeHotel(1).get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listar(){
        try {
            administradorHotelServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
