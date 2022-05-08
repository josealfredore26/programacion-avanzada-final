package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HabitacionRepo extends JpaRepository<Habitacion,Integer> {

    List<Habitacion> findAllByHotel(Hotel hotel);

    @Query("select h from Habitacion h join h.reservas r where (r.fechaFinal < :entrada) or (r.fechaInicio > :salida)")
    List<Habitacion> listarHabitacionesDisponiblesEntreFechas(LocalDate entrada, LocalDate salida);

}
