package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Cliente;

import java.util.List;

public interface ClienteServicio {

    Cliente login(String email, String password) throws Exception;

    Cliente registrarCliente (String cedula, String nombre, String email, String password, Ciudad ciudad, List<String> telefonos) throws Exception;

    Cliente actualizarCliente (String cedula, String nombre, String email, String password, Ciudad ciudad) throws Exception;

    boolean eliminarClientePorCedula (String cedula) throws Exception;

    Cliente buscarClientePorCedula (String cedula) throws Exception;

    List<Cliente> listar() throws Exception;

    boolean recuperarPasswordUsandoCorreoElectronico(String email) throws Exception;

    boolean verificarNumeroEnListadoDeTelefonos(String numero);

}
