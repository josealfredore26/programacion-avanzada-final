package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Cliente;
import co.edu.uniquindio.proyecto.Interfaces.ClienteServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ClienteServicioTest {

    @Autowired
    ClienteServicio clienteServicio;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarClienteTest() {
        try{
            ArrayList<String> telefonos = new ArrayList<String>();
            telefonos.add("123456789");
            clienteServicio.registrarCliente("0012340921", "Jose Alfredo", "josealfredore200326@gmail.com", "miPassword", ciudadRepo.getById(1), telefonos);
            clienteServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Jose Alfredo", clienteRepo.findById("0012340921").get().getNombre());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void ActualizarClienteTest(){
        try {
            clienteServicio.actualizarCliente("1000000001","Pablo andres","pablitoal157@gmail.com","pab123",ciudadRepo.getById(2));
            clienteServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Pablo andres", clienteRepo.findById("1000000001").get().getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarClienteTest(){
        try {
            clienteServicio.eliminarClientePorCedula("1000000002");
            Assertions.assertNull(clienteRepo.findById("1000000002").orElse(null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarClientePorCedula() {
        try {
            System.out.println(clienteServicio.buscarClientePorCedula("1000000001"));
            Assertions.assertEquals("Jose Ramirez", clienteServicio.buscarClientePorCedula("1000000001").getNombre());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listar() {
        try {
            clienteServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void recuperarPasswordPorEmailClienteTest() {
        try{
            System.out.println(clienteServicio.recuperarPasswordUsandoCorreoElectronico("josealfredore133@gmail.com"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

