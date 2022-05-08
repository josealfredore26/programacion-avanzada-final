package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.AdministradorHotel;
import co.edu.uniquindio.proyecto.Entidades.Caracteristica;
import co.edu.uniquindio.proyecto.Entidades.Comentario;

import java.util.List;

public interface ComentarioServicio {

    Comentario agregarComentario (Integer hotelId, String contenido, Integer calificacion) throws Exception;

    Comentario actualizarComentario (Integer codigo, String contenido, Integer calificacion) throws Exception;

    boolean eliminarComentario (Integer codigo) throws Exception;

    Comentario buscarComentarioPorCodigo (Integer codigo) throws Exception;

    List<Comentario> buscarComentarioPorCalificacion (Integer calificacion) throws Exception;

    List<Comentario> listar() throws Exception;

}
