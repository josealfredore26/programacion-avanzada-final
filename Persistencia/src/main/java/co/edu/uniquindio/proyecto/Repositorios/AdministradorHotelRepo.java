package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorHotelRepo extends JpaRepository<AdministradorHotel, String> {

    Optional<AdministradorHotel> findByEmailAndAndPassword(String email, String password);

    Optional<AdministradorHotel> findByCodigo(Integer codigo);

    boolean existsByCodigo(Integer codigo);

    Optional<AdministradorHotel> deleteByCodigo(Integer codigo);

    Optional<AdministradorHotel> findByNombre(String nombre);

    @Query("select a from AdministradorHotel a where upper(a.nombre) = :nombre ")
    Optional<AdministradorHotel> buscarPorNombre(String nombre);

    Optional<AdministradorHotel> findByEmail(String email);

    @Query("select h.administradorHotel from Hotel h where h.codigo = :codigo")
    Optional<AdministradorHotel> buscarPorCodigoDeHotel(Integer codigo);

}
