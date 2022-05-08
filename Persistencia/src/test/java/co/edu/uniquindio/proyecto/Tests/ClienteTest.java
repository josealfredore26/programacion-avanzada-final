package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Administrador;
import co.edu.uniquindio.proyecto.Entidades.Cliente;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private CiudadRepo ciudadRepo;


    @Test
    @Sql("classpath:datos.sql")
    public void registrarCliente(){

        Cliente cliente = new Cliente();
        String cedula, nombre, email, password;
        cedula = "7891234569";
        nombre = "Abel Antonio";
        email = "abelantonio@email.com";
        password = "abelantonio123";
        cliente.setCedula(cedula);
        cliente.setNombre(nombre);
        cliente.setEmail(email);
        cliente.setPassword(password);
        cliente.setCiudad(ciudadRepo.getById(1));
        clienteRepo.save(cliente);
        Assertions.assertEquals("Abel Antonio", clienteRepo.findById("7891234569").get().getNombre());

        List<Cliente> lista = clienteRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarCliente(){

        Cliente clienteBuscar = clienteRepo.findById("1000000001").orElse(null);

        clienteBuscar.setNombre("Pablo lozano");

        clienteRepo.save(clienteBuscar);

        List<Cliente> lista = clienteRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarCliente(){

        clienteRepo.deleteById("1000000001");
        Assertions.assertNull( clienteRepo.findById("1000000001").orElse(null));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarCliente(){

        clienteRepo.findById("1000000001");
        Assertions.assertEquals("Jose Ramirez",  clienteRepo.findById("1000000001").orElse(null).getNombre());

    }


    @Test
    @Sql("classpath:datos.sql")
    public void listarCliente(){

        List<Cliente> lista = clienteRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

}
