package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.VueloServicio;
import co.edu.uniquindio.proyecto.Repositorios.CiudadRepo;
import co.edu.uniquindio.proyecto.Repositorios.SillaRepo;
import co.edu.uniquindio.proyecto.Repositorios.VueloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VueloServicioImpl implements VueloServicio {

    @Autowired
    private VueloRepo vueloRepo;

    @Autowired
    private CiudadRepo ciudadRepo;

    @Override
    public Vuelo agregarVuelo(Ciudad origen, Ciudad destino, Integer cantidadDeSillas, LocalDate fecha) throws Exception {
        if(ciudadRepo.existsById(origen.getCodigo()) && ciudadRepo.existsById(destino.getCodigo())) {
            Vuelo vuelo = new Vuelo(origen,destino,cantidadDeSillas,fecha);
            return vueloRepo.save(vuelo);
        } else {
            throw new Exception("No es valido el origen indicado o el destino indicado.");
        }

    }

    @Override
    public Vuelo actualizarVuelo(Integer codigo, Ciudad origenNuevo, Ciudad destinoNuevo, Integer cantidadDeSillasNuevo, LocalDate fechaNueva) throws Exception {

        if(vueloRepo.existsById(codigo)) {
            if(ciudadRepo.existsById(origenNuevo.getCodigo()) && ciudadRepo.existsById(destinoNuevo.getCodigo())) {
                Vuelo vueloAux = vueloRepo.getById(codigo);

                vueloAux.setOrigen(origenNuevo);
                vueloAux.setDestino(destinoNuevo);
                vueloAux.setCantidadDeSillas(cantidadDeSillasNuevo);
                vueloAux.setFecha(fechaNueva);

                return vueloRepo.save(vueloAux);
            } else {
                throw new Exception("No es valido el origen indicado o el destino indicado.");
            }
        } else {
            throw new Exception("No existe un vuelo con ese codigo.");
        }
    }

    @Override
    public boolean eliminarVuelo(Integer codigo) throws Exception {
        if (vueloRepo.findById(codigo).isPresent()){
            vueloRepo.deleteById(codigo);
        }else {
            throw new Exception("No existe un vuelo con el codigo indicado.");
        }

        if (vueloRepo.existsById(codigo)){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Vuelo buscarVueloPorCodigo(Integer codigo) throws Exception {
        if(vueloRepo.existsById(codigo)) {
            return vueloRepo.findById(codigo).get();
        } else {
            throw new Exception("No existe un vuelo con ese codigo");
        }
    }

    @Override
    public List<Vuelo> buscarVueloPorOrigen(String origen) throws Exception {
        return vueloRepo.buscarPorNombreDeCiudadDeOrigen(origen);
    }

    @Override
    public List<Vuelo> buscarVueloPorDestino(String destino) throws Exception {
        return vueloRepo.buscarPorNombreDeCiudadDeDestino(destino);
    }

    @Override
    public List<Vuelo> buscarVueloPorFecha(LocalDate fecha) throws Exception {
        return vueloRepo.findByFecha(fecha);
    }

    @Override
    public List<Vuelo> listar() {
        return vueloRepo.findAll();
    }

}
