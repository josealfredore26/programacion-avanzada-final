package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.Cama;
import co.edu.uniquindio.proyecto.Entidades.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaracteristicaRepo extends JpaRepository<Caracteristica, Integer> {


    Optional<Caracteristica> findByContenido(String contenido);

    @Query("select c from Caracteristica c where upper(c.contenido) like concat('%' , :contenido, '%')")
    List<Caracteristica> listarPorContenido(String contenido);

    @Query("select c from Caracteristica c where upper(c.contenido) = :contenido ")
    Optional<Caracteristica> buscarCarcteristicaPorContenido(String contenido);

}
