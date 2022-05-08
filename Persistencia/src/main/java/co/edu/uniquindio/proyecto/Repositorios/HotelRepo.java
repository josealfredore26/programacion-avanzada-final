package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {

    Optional<Hotel> findByNombre(String nombre);

    @Query("select h from Hotel h where upper(h.nombre) like concat ('%' , :nombre , '%')")
    List<Hotel> buscarPorNombre(String nombre);

    @Query("select h from Hotel h where upper(h.nombre) = :nombre")
    Optional<Hotel> buscarPorNombreExacto(String nombre);

    List<Hotel> findAllByDestino(Ciudad ciudad);

    @Query("select h from Hotel h where h.destino.nombre = :nombreCiudad")
    List<Hotel> buscarHotelesPorCiudadEspecifica(String nombreCiudad);

    @Query("select h from Hotel h where upper(h.destino.nombre) like concat('%', :nombreCiudad, '%')")
    List<Hotel> buscarHotelesPorCiudadAproximada(String nombreCiudad);

    Hotel getByNombre(String nombre);

}
