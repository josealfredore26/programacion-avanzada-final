package co.edu.uniquindio.proyecto.Tests;

import co.edu.uniquindio.proyecto.Interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.NegocioApplication;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.Repositorios.HotelRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class ComentarioServicioTest {

    @Autowired
    ComentarioRepo comentarioRepo;

    @Autowired
    ComentarioServicio comentarioServicio;

    @Autowired
    HotelRepo hotelRepo;

    @Test
    @Sql("classpath:datos.sql")
    public void agregarComentarioTest() {
        try {
            comentarioServicio.agregarComentario(hotelRepo.getById(1).getCodigo(),"Buen hotel 5 estrelas",5);
            comentarioServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Buen hotel 5 estrelas", comentarioRepo.findById(5).get().getComentario());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void actualizarComentarioTest()  {
        try {
            comentarioServicio.actualizarComentario(3,"Buen hotel 5 estrelas",5);
            comentarioServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertEquals("Buen hotel 5 estrelas", comentarioRepo.findById(3).get().getComentario());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void eliminarComentarioTest()  {
        try {
            comentarioServicio.eliminarComentario(2);
            comentarioServicio.listar().forEach(u -> System.out.println(u));
            Assertions.assertNull(comentarioRepo.findById(2).orElse(null));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarComentarioPorCodigoTest()  {
        try {
            System.out.println(comentarioServicio.buscarComentarioPorCodigo(1));
            Assertions.assertEquals("Que chimba so", comentarioServicio.buscarComentarioPorCodigo(1).getComentario());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void buscarComentarioPorCalificacionTest() {
        try {
            System.out.println(comentarioServicio.buscarComentarioPorCalificacion(5));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:datos.sql")
    public void listarTest(){
        try {
            comentarioServicio.listar().forEach(u -> System.out.println(u));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}