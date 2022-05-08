package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Interfaces.AdministradorServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class AdministradorServicioTest {

    @Autowired
    AdministradorRepo administradorRepo;

    @Autowired
    AdministradorServicio administradorServicio;

    @Test
    @Sql("classpath:datos.sql")
    public void loginTest(){
        try {
            administradorServicio.login("administrador1@email.com","emiliano123");
            System.out.println("Ingreso exitoso");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
