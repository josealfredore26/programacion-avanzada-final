package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Hotel;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import co.edu.uniquindio.proyecto.Interfaces.HabitacionServicio;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import co.edu.uniquindio.proyecto.Repositorios.HotelRepo;
import co.edu.uniquindio.proyecto.Repositorios.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HabitacionServicioImpl implements HabitacionServicio {

    @Autowired
    HabitacionRepo habitacionRepo;

    @Autowired
    HotelRepo hotelRepo;

    @Autowired
    ReservaRepo reservaRepo;

    @Override
    public Habitacion agregarHabitacion(Hotel hotel, Double precio) throws Exception {
        if(hotelRepo.findById(hotel.getCodigo()).isPresent()) {
            if(precio.doubleValue() > 0.0) {
                Habitacion habitacion = new Habitacion();
                habitacion.setHotel(hotel);
                habitacion.setNumero(habitacionRepo.findAllByHotel(hotel).size()+1);
                habitacion.setPrecio(precio);
                return habitacionRepo.save(habitacion);
            } else {
                throw new Exception("El precio indicado no es valido");
            }
        } else {
            throw new Exception("No existe el hotel indicado.");
        }
    }

    @Override
    public List<Habitacion> listarHabitaciones() {
        return habitacionRepo.findAll();
    }

    @Override
    public List<Habitacion> listarHabitacionesDisponiblesPorFechas(LocalDate entrada, LocalDate salida) throws Exception {
        if(entrada.isBefore(salida)) {
            List<Habitacion> habitaciones = listarHabitaciones();
            List<Habitacion> listaDefinitiva = new ArrayList<Habitacion>();
            for(int i = 0; i < habitaciones.size(); i++) {
                List<Reserva> reservas = reservaRepo.listarReservaPorHabitacion(habitaciones.get(i).getCodigo());
                List<Reserva> reservas2 = reservaRepo.listarReservasConVerificacionDeFechas(entrada, salida);
                if(reservas.size() == reservas2.size()) {
                    listaDefinitiva.add(habitaciones.get(i));
                }
            }
            return listaDefinitiva;
        } else {
            throw new Exception("La fecha de entrada ingresada es depues que la fecha de salida.");
        }
    }


}
