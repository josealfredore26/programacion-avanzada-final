package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Caracteristica;
import co.edu.uniquindio.proyecto.Interfaces.CaracteristicaServicio;
import co.edu.uniquindio.proyecto.Repositorios.CaracteristicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CaracteristicaServicioImpl implements CaracteristicaServicio {

    @Autowired
    private CaracteristicaRepo caracteristicaRepo;

    @Override
    public Caracteristica agregarCaracteristica(String contenido) throws Exception {

        String aux = contenido.trim();
        if(caracteristicaRepo.buscarCarcteristicaPorContenido(aux.toUpperCase()).isPresent()) {
            throw new Exception("Ya existe una caracteristica con ese contenido.");
        } else {
            Caracteristica caracteristica = new Caracteristica();
            caracteristica.setContenido(contenido.trim());
            return caracteristicaRepo.save(caracteristica);
        }
    }

    @Override
    public Caracteristica actualizarCaracteristica(Integer codigo, String contenido) throws Exception {
        if(caracteristicaRepo.findById(codigo).isPresent()){
            if(caracteristicaRepo.buscarCarcteristicaPorContenido(contenido.toUpperCase()).isEmpty()) {
                String aux = contenido.trim();
                Caracteristica auxCaracteristica = caracteristicaRepo.getById(codigo);
                auxCaracteristica.setContenido(contenido.trim());
                return caracteristicaRepo.save(auxCaracteristica);
            } else {
                throw new Exception("Ya existe una caracteristica asi");
            }
        } else {
            throw new Exception("No existe una caracteristica con ese codigo");
        }


    }

    @Override
    public boolean eliminarCaracteristica(Integer codigo) throws Exception {
        if(caracteristicaRepo.findById(codigo).isPresent()) {
            caracteristicaRepo.deleteById(codigo);
        } else {
            throw new Exception("No existe una caracteristica con este codigo.");
        }

        if(caracteristicaRepo.existsById(codigo)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Caracteristica buscarCaracteristica(Integer codigo) throws Exception {
        Optional<Caracteristica> caracteristica = caracteristicaRepo.findById(codigo);
        if(caracteristica.isPresent()) {
            return caracteristica.get();
        } else {
            throw new Exception("No existe una caracteristica con ese codigo");
        }
    }

    @Override
    public List<Caracteristica> buscarCaracteristicasPorContenido(String contenido) throws Exception {
        return caracteristicaRepo.listarPorContenido(contenido.toUpperCase());
    }

    @Override
    public List<Caracteristica> listar() throws Exception {
        return caracteristicaRepo.findAll();
    }
}
