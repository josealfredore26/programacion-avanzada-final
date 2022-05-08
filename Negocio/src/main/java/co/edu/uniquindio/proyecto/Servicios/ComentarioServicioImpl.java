package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Comentario;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import co.edu.uniquindio.proyecto.Interfaces.ComentarioServicio;
import co.edu.uniquindio.proyecto.Repositorios.ComentarioRepo;
import co.edu.uniquindio.proyecto.Repositorios.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    @Autowired
    private ComentarioRepo comentarioRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Comentario agregarComentario(Integer hotelId, String contenido, Integer calificacion) throws Exception {
        Comentario comentario = new Comentario ();
        comentario.setComentario(contenido);
        comentario.setCalificacion(calificacion);
        comentario.setHotel(hotelRepo.getById(hotelId));
        return comentarioRepo.save(comentario);
    }

    @Override
    public Comentario actualizarComentario(Integer codigo, String contenido, Integer calificacion) throws Exception {
        if(comentarioRepo.existsById(codigo)){
            Comentario comentario = comentarioRepo.getById(codigo);
            comentario.setComentario(contenido);
            comentario.setCalificacion(calificacion);
            return comentarioRepo.save(comentario);
        } else {
            throw new Exception("No existe un comentario con ese codigo");
        }
    }

    @Override
    public boolean eliminarComentario(Integer codigo) throws Exception {
        if(comentarioRepo.existsById(codigo)) {
            comentarioRepo.deleteById(codigo);
        } else {
            throw new Exception("No existe un comentario con ese codigo");
        }
        if(comentarioRepo.existsById(codigo)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Comentario buscarComentarioPorCodigo(Integer codigo) throws Exception {
        if(comentarioRepo.existsById(codigo)) {
            return comentarioRepo.findById(codigo).get();
        } else {
            throw new Exception("No existe un comentario con ese codigo");
        }
    }

    @Override
    public List<Comentario> buscarComentarioPorCalificacion(Integer calificacion) throws Exception {
        return comentarioRepo.findAllByCalificacion(calificacion);
    }

    @Override
    public List<Comentario> listar() throws Exception {
        return comentarioRepo.findAll();
    }
}
