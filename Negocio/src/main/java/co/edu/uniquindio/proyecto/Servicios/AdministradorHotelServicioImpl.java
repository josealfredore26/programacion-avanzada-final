package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import co.edu.uniquindio.proyecto.Interfaces.AdministradorHotelServicio;
import co.edu.uniquindio.proyecto.Repositorios.AdministradorHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorHotelServicioImpl implements AdministradorHotelServicio {

    @Autowired
    private AdministradorHotelRepo administradorHotelRepo;

    @Override
    public AdministradorHotel login(String email, String password) throws Exception {
        return  administradorHotelRepo.findByEmailAndAndPassword(email,password).orElseThrow(() -> new Exception("Datos Incorrectos"));
    }

    @Override
    public AdministradorHotel agregarAdministradorDeHotel(String cedula, String nombre, String email, String password) throws Exception {
        int tamanio;
        List<AdministradorHotel> administradorHotelList = administradorHotelRepo.findAll();
        Optional<AdministradorHotel> buscar = administradorHotelRepo.findById(cedula);

        if (buscar.isPresent()){
            throw new Exception("El administrador ya existe");
        }

        buscar = administradorHotelRepo.findByEmail(email);

        if (buscar.isPresent()){
            throw new Exception("El email ya se encuentra en uso");
        }

        if (administradorHotelList.isEmpty()) {
            tamanio = 0;
        } else {
            tamanio = administradorHotelList.size();
        }

        AdministradorHotel administradorHotel = new AdministradorHotel(cedula, nombre, email, password, tamanio+1);
//        administradorHotel.setHoteles(new ArrayList<Hotel>());


        return administradorHotelRepo.save(administradorHotel);
    }

    @Override
    public AdministradorHotel actualizarAdministradorDeHotel(String cedula, String nombre, String email, String password, Integer codigo) throws Exception {

        Optional<AdministradorHotel> buscar = administradorHotelRepo.findById(cedula);

        if(buscar.isEmpty()){
            throw new Exception("El administrador no existe");
        }


        AdministradorHotel aux = administradorHotelRepo.getById(cedula);

        aux.setNombre(nombre);
        aux.setEmail(email);
        aux.setPassword(password);
        aux.setCodigo(codigo);



        return administradorHotelRepo.save(aux);
    }

    @Override
    public boolean eliminarAdministradorDeHotelPorCedula(String cedula) throws Exception {
        if(administradorHotelRepo.findById(cedula).isPresent()) {
            administradorHotelRepo.deleteById(cedula);
        }else{
            throw new Exception("El administrador no existe");
        }

        if(administradorHotelRepo.existsById(cedula)) {
            return false;
        } else {
            return true;
        }
    }

/*    @Override
    public boolean eliminarAdministradorDeHotelPorCodigo(Integer codigo) throws Exception {
        if(administradorHotelRepo.findByCodigo(codigo).isPresent()) {
            administradorHotelRepo.deleteByCodigo(codigo);
        }
        if(administradorHotelRepo.existsByCodigo(codigo)) {
            return false;
        } else {
            return true;
        }
    }*/

    @Override
    public AdministradorHotel buscarAdministradorDeHotelPorCedula(String cedula) throws Exception {
        return administradorHotelRepo.findById(cedula).orElseThrow(() -> new Exception("No existe un cliente registrado con esa cedula"));
    }

    @Override
    public AdministradorHotel buscarAdministradorDeHotelPorCodigo(Integer codigo) throws Exception {
        return administradorHotelRepo.findByCodigo(codigo).orElseThrow(() -> new Exception("No existe un administrador de hotel registrado con este codigo"));
    }

    @Override
    public AdministradorHotel buscarAdministradorDeHotelPorHotel(Integer codigo) throws Exception {
        return administradorHotelRepo.buscarPorCodigoDeHotel(codigo).orElseThrow(() -> new Exception("No existe un hotel registrado con este codigo"));
    }

    @Override
    public List<AdministradorHotel> listar()  {
        return administradorHotelRepo.findAll();
    }
}
