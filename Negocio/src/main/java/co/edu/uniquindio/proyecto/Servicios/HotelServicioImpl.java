package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import co.edu.uniquindio.proyecto.Interfaces.HotelServicio;
import co.edu.uniquindio.proyecto.Repositorios.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServicioImpl implements HotelServicio {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel agregarHotel(String nombre, String direccion, Integer numeroDeEstrellas, Ciudad ciudad, AdministradorHotel administradorHotel) throws Exception {

        String aux = nombre.trim();

        Optional<Hotel> buscar = hotelRepo.buscarPorNombreExacto(aux.toUpperCase());

        if (buscar.isPresent()){
            throw new Exception("Ya existe un hotel con este nombre.");
        }

             Hotel hotel = new Hotel(nombre.trim(), direccion, numeroDeEstrellas, ciudad, administradorHotel);


        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel actualizarHotel(Integer codigo, String nombre, String direccion, Integer numeroDeEstrellas, Ciudad ciudad, AdministradorHotel administradorHotel) throws Exception {
        if(hotelRepo.findById(codigo).isPresent()) {
            String aux = nombre.trim();

            Optional<Hotel> buscar = hotelRepo.buscarPorNombreExacto(aux.toUpperCase());

            if (buscar.isEmpty()){
                throw new Exception("No existe un hotel con este nombre.");
            } else {

                Hotel hotelAux = hotelRepo.getById(codigo);
                hotelAux.setNombre(nombre.trim());
                hotelAux.setDireccion(direccion);
                hotelAux.setNumeroDeEstrellas(numeroDeEstrellas);
                hotelAux.setDestino(ciudad);
                hotelAux.setAdministradorHotel(administradorHotel);

                return hotelRepo.save(hotelAux);
            }
        } else {
            throw new Exception("No existe un hotel con el codigo indicado");
        }
    }

    @Override
    public boolean eliminarHotel(Integer codigo) throws Exception {
        if (hotelRepo.findById(codigo).isPresent()){
            hotelRepo.deleteById(codigo);
        }else {
            throw new Exception("No existe un hotel con ese codigo");
        }

        if (hotelRepo.existsById(codigo)){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<Hotel> buscarHotelPorNombre(String nombre) throws Exception {
        return hotelRepo.buscarPorNombre(nombre.toUpperCase());
    }

    @Override
    public Hotel buscarHotelPorCodigo(Integer codigo) throws Exception {
        return hotelRepo.findById(codigo).orElseThrow(() -> new Exception("No existe un hotel con ese codigo"));
    }

    @Override
    public List<Hotel> listar() throws Exception {
        return hotelRepo.findAll();
    }

    @Override
    public List<Hotel> listarHotelPorCiudad(String nombreCiudad) throws Exception {
        return hotelRepo.buscarHotelesPorCiudadAproximada(nombreCiudad.trim().toUpperCase());
    }

}
