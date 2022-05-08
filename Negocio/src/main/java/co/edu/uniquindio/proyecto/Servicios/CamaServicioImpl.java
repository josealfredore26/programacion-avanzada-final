package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Cama;
import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.TipoCama;
import co.edu.uniquindio.proyecto.Interfaces.CamaServicio;
import co.edu.uniquindio.proyecto.Repositorios.CamaRepo;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CamaServicioImpl implements CamaServicio {

    @Autowired
    CamaRepo camaRepo;

    @Autowired
    HabitacionRepo habitacionRepo;

    @Override
    public Cama agregarCama(Habitacion habitacion, TipoCama tipo) throws Exception {
        if(habitacionRepo.findById(habitacion.getCodigo()).isPresent()) {
            Cama cama = new Cama();
            cama.setTipo(tipo);
            cama.setHabitacion(habitacion);
            cama.setNumero(camaRepo.findAllByHabitacion(habitacion).size()+1);
            return camaRepo.save(cama);
        } else {
            throw new Exception("No existe la habitación indicada.");
        }
    }
}
