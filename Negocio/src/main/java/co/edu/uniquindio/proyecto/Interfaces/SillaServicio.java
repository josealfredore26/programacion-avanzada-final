package co.edu.uniquindio.proyecto.Interfaces;

import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Entidades.Vuelo;

import java.util.List;

public interface SillaServicio {

    Silla agregarSilla (Double precio, boolean disponibilidad, Vuelo vuelo) throws Exception;

    List<Silla> listarPorVuelo(Vuelo vuelo) throws Exception;

    public boolean verificarExistenciaDeNumero(Vuelo vuelo, int numero) ;

    }
