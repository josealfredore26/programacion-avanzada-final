package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.Cama;
import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamaRepo extends JpaRepository<Cama, Integer> {

    List<Cama> findAllByHabitacion(Habitacion habitacion);

}
