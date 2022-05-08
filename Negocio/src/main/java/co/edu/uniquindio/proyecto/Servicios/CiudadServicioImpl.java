package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Cliente;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import co.edu.uniquindio.proyecto.Interfaces.CiudadServicio;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicioImpl implements CiudadServicio {

    @Autowired
    private CiudadRepo ciudadRepo;

    @Autowired
    private ClienteRepo clienteRepo;

    @Override
    public Ciudad agregarCiudad(String nombre) throws Exception {
        String aux = nombre.trim();

        if (ciudadRepo.buscarPorNombre(aux.toUpperCase()).isPresent()) {
            throw new Exception("Ya existe una ciudad con ese nombre en especifico.");
        }

        for (int i=0;i<aux.length();i++){
            if (Character.isDigit(aux.charAt(i))){
                throw new Exception("Nombre de cuidad incorecto.");
            }
        }

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre(nombre.trim());

        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad(Integer codigo, String nombreNuevo) throws Exception {
        String aux = nombreNuevo.trim();

        if(ciudadRepo.buscarPorNombre(aux.toUpperCase()).isPresent()) {
            throw new Exception("Ya existe una ciudad con ese nombre en especifico.");

        }

        for (int i=0;i<aux.length();i++){
            if (Character.isDigit(aux.charAt(i))){
                throw new Exception("Nombre de cuidad incorecto.");
            }
        }

        Ciudad ciudad = ciudadRepo.getById(codigo);
        ciudad.setNombre(nombreNuevo.trim());

        return ciudadRepo.save(ciudad);
    }

    @Override
    public boolean eliminarCiudad(Integer codigo) throws Exception {
        if(ciudadRepo.findById(codigo).isPresent()) {
            List<Cliente> clientes = clienteRepo.findAllByCiudad(ciudadRepo.getById(codigo));
            for(int i = 0; i < clientes.size(); i++){
                clientes.get(i).setTelefono(null);

            }
            ciudadRepo.deleteById(codigo);
            return true;
        } else {
            throw new Exception("No existe una ciudad con ese codigo.");
        }
    }

    @Override
    public List<Ciudad> buscarCiudad(String nombre) throws Exception {
        return ciudadRepo.listarPorNombre(nombre);
    }

    @Override
    public List<Ciudad> listar() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad obtenerCuidad(Integer id) throws Exception {
        return ciudadRepo.findById(id).get();
    }

}
