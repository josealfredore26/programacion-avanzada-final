package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Entidades.Comentario;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ComentarioTest {

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void registrarComentario(){

        Comentario comentario = new Comentario();
        Integer calificacion;
        String  descripcion;
        calificacion = 4;
        descripcion = "cr 19 25N-50";
        comentario.setCalificacion(calificacion);
        comentario.setComentario(descripcion);
        comentarioRepo.save(comentario);
        Assertions.assertEquals("cr 19 25N-50", comentarioRepo.findById(5).get().getComentario());

        List<Comentario> lista = comentarioRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }


    @Test
    @Sql("classpath:datos.sql")
    public void actualizarComentario(){

        Comentario comentarioBuscar = comentarioRepo.findById(1).orElse(null);

        comentarioBuscar.setComentario("hotel lozano");

        comentarioRepo.save(comentarioBuscar);

        List<Comentario> lista = comentarioRepo.findAll();

        lista.forEach(u -> System.out.println(u));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarComentario(){

        comentarioRepo.deleteById(2);
        Assertions.assertNull(comentarioRepo.findById(2).orElse(null));

    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarComentario(){

        comentarioRepo.findById(1);
        Assertions.assertEquals("Que chimba so",  comentarioRepo.findById(1).orElse(null).getComentario());

    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarComentario(){

        List<Comentario> lista = comentarioRepo.findAll();

        lista.forEach(u -> System.out.println(u));
    }


}
