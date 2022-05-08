package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Administrador;
import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void crearTest() {

        Administrador administrador = new Administrador("7891234569",
                "Abel Antonio", "abelantonio@email.com", "abelantonio123", administradorRepo.findAll().size()+1);

        administradorRepo.save(administrador);
        System.out.println(administradorRepo.getById("7891234569").toString() + "\nCodigo: " + administradorRepo.getById("7891234569").getCodigo());
        Assertions.assertEquals("Abel Antonio", administradorRepo.findById("7891234569").get().getNombre());

        List<Administrador> administradorList = administradorRepo.findAll();
        if(!administradorList.isEmpty()) {
            for (Administrador administrador2 : administradorList) {
                System.out.println(administrador2.toString());
                //System.out.println("Codigo: " + administrador2.getCodigo());
            }
        }


    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarTest() {

        Administrador a = administradorRepo.findById("1234567890").orElse(null);
        Assertions.assertEquals("Emiliano Zuleta",  a.getNombre());
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarTest() {

        Administrador administrador = administradorRepo.getById("1234567890");
        System.out.println("El nombre es: " + administrador.getNombre());
        Assertions.assertEquals("Emiliano Zuleta",  administradorRepo.findById("1234567890").get().getNombre());

        administrador.setNombre("Juancho Polo");
        administradorRepo.save(administrador);

        System.out.println("El nombre es: " + administrador.getNombre());
        Assertions.assertEquals("Juancho Polo",  administradorRepo.findById("1234567890").get().getNombre());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarTest() {



        for(Administrador administrador : administradorRepo.findAll()) {
            System.out.println("Cedula: " + administrador.getCedula() + "\nNombre: " + administrador.getNombre());
        }

        System.out.println("-----------------------------------------\n");

        administradorRepo.deleteById("1234567890");

        for(Administrador administrador : administradorRepo.findAll()) {
            System.out.println("Cedula: " + administrador.getCedula() + "\nNombre: " + administrador.getNombre());
        }

        System.out.println(administradorRepo.existsById("1234567890"));
        if(administradorRepo.findById("1234567890").isEmpty()) {
            System.out.println("El administrador ha sido eliminado correctamente");
        }

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest() {

        List<Administrador> administradorList = administradorRepo.findAll();
        if(!administradorList.isEmpty()) {
            for (Administrador administrador : administradorList) {
                System.out.println(administrador.toString());
            }
        }

    }

}
