package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import co.edu.uniquindio.proyecto.Interfaces.SillaServicio;
import co.edu.uniquindio.proyecto.Repositorios.SillaRepo;
import co.edu.uniquindio.proyecto.Repositorios.VueloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SillaServicioImpl implements SillaServicio {

    @Autowired
    private SillaRepo sillaRepo;

    @Autowired
    private VueloRepo vueloRepo;

    @Override
    public Silla agregarSilla(Double precio, boolean disponibilidad, Vuelo vuelo) throws Exception {
        boolean aux = true;
        if(vueloRepo.findById(vuelo.getCodigo()).isPresent()) {
            vuelo = vueloRepo.getById(vuelo.getCodigo());
            if(vuelo.getCantidadDeSillas() > sillaRepo.findAllByVuelo(vuelo).size()) {
                Silla silla = new Silla();
                silla.setValor(precio);
                silla.setVuelo(vuelo);
                do {
                    int numeroDeSilla = (int) (Math.random()*(vuelo.getCantidadDeSillas()-1)) + 1;
                    if(verificarExistenciaDeNumero(vuelo, numeroDeSilla) != true) {
                        silla.setNumero(numeroDeSilla);
                        aux = false;
                    }
                }while(aux == true);
                return sillaRepo.save(silla);
            } else {
                throw new Exception("El vuelo ya esta lleno. No se puede asignar otro asiento.");
            }
        } else {
            throw new Exception("No existe el vuelo indicado.");
        }
    }

    @Override
    public boolean verificarExistenciaDeNumero(Vuelo vuelo, int numero) {
        List<Silla> sillas = sillaRepo.findAllByVuelo(vuelo);
        for(int i = 0; i < sillas.size(); i++) {
            if(sillas.get(i).getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Silla> listarPorVuelo(Vuelo vuelo) throws Exception {
        if(vueloRepo.findById(vuelo.getCodigo()).isPresent()) {
            return sillaRepo.findAllByVuelo(vuelo);
        } else {
            throw new Exception("No existe el vuelo indicado");
        }
    }
}
