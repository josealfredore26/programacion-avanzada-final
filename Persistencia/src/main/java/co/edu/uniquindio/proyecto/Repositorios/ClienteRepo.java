package co.edu.uniquindio.proyecto.Repositorios;

import co.edu.uniquindio.proyecto.Entidades.Ciudad;
import co.edu.uniquindio.proyecto.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    Optional<Cliente> findByEmailAndPassword(String email, String Password);

    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findByNombre(String nombre);

    @Query("select c.password from Cliente c where c.email = :email")
    String recuperarPasswordConEmail(String email);

    List<Cliente> findAllByCiudad(Ciudad ciudad);
}
