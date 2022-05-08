package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VueloRepo extends JpaRepository<Vuelo,Integer> {

    List<Vuelo> findByFecha (LocalDate fechaSalida);

    List<Vuelo> findByDestino (Ciudad destino);

    List<Vuelo> findByOrigen (Ciudad origen);

    @Query("select v from Vuelo v where v.origen.nombre like concat('%', :origen, '%')")
    List<Vuelo> buscarPorNombreDeCiudadDeOrigen(String origen);

    @Query("select v from Vuelo v where v.destino.nombre like concat('%', :destino, '%')")
    List<Vuelo> buscarPorNombreDeCiudadDeDestino(String destino);

}
