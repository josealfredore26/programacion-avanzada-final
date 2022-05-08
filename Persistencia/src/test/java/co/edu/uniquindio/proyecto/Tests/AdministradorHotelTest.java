package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorHotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorHotelTest{

    @Autowired
    private AdministradorHotelRepo administradorRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void crearTest() {

        AdministradorHotel administrador = new AdministradorHotel();
        String cedula, nombre, email, password;
        Integer codigo;
        cedula = "7891234569";
        nombre = "Abel Antonio";
        email = "abelantonio@email.com";
        password = "abelantonio123";
        codigo = administradorRepo.findAll().size()+1;
        administrador.setCedula(cedula);
        administrador.setNombre(nombre);
        administrador.setEmail(email);
        administrador.setPassword(password);
        administrador.setCodigo(codigo);
        administradorRepo.save(administrador);
        System.out.println(administradorRepo.getById("7891234569").toString() + "\nCodigo: " + administradorRepo.getById("7891234569").getCodigo());
        Assertions.assertEquals("Abel Antonio", administradorRepo.findById("7891234569").get().getNombre());

        List<AdministradorHotel> administradorList = administradorRepo.findAll();
        if(!administradorList.isEmpty()) {
            for (AdministradorHotel administrador2 : administradorList) {
                System.out.println(administrador2.toString());
                System.out.println("Codigo: " + administrador2.getCodigo());
            }
        }


    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        administradorRepo.findById("2345678901").orElse(null);
        Assertions.assertEquals("Nicolas Mendoza",  administradorRepo.findById("2345678901").orElse(null).getNombre());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {

        AdministradorHotel administrador = administradorRepo.getById("2345678901");
        System.out.println("El nombre es: " + administrador.getNombre());
        Assertions.assertEquals("Nicolas Mendoza",  administradorRepo.findById("2345678901").get().getNombre());

        administrador.setNombre("Juancho Polo");
        administradorRepo.save(administrador);

        System.out.println("El nombre es: " + administrador.getNombre());
        Assertions.assertEquals("Juancho Polo",  administradorRepo.findById("2345678901").get().getNombre());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {

        for(AdministradorHotel administrador : administradorRepo.findAll()) {
            System.out.println("Cedula: " + administrador.getCedula() + "\nNombre: " + administrador.getNombre());
        }

        System.out.println("-----------------------------------------\n");
        administradorRepo.deleteById("2345678901");

        for(AdministradorHotel administrador : administradorRepo.findAll()) {
            System.out.println("Cedula: " + administrador.getCedula() + "\nNombre: " + administrador.getNombre());
        }

        System.out.println(administradorRepo.existsById("2345678901"));
        if(administradorRepo.findById("2345678901").isEmpty()) {
            System.out.println("El administrador ha sido eliminado correctamente");
        }

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest() {

        List<AdministradorHotel> administradorList = administradorRepo.findAll();
        if(!administradorList.isEmpty()) {
            for (AdministradorHotel administrador : administradorList) {
                System.out.println(administrador.toString());
            }
        }

    }

}
