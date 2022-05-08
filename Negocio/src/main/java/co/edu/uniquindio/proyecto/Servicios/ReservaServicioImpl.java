package co.edu.uniquindio.proyecto.Servicios;

import co.edu.uniquindio.proyecto.Entidades.Cliente;
import co.edu.uniquindio.proyecto.Entidades.Habitacion;
import co.edu.uniquindio.proyecto.Entidades.Reserva;
import co.edu.uniquindio.proyecto.Entidades.Silla;
import co.edu.uniquindio.proyecto.Interfaces.ReservaServicio;
import co.edu.uniquindio.proyecto.Repositorios.ClienteRepo;
import co.edu.uniquindio.proyecto.Repositorios.HabitacionRepo;
import co.edu.uniquindio.proyecto.Repositorios.ReservaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservaServicioImpl implements ReservaServicio {

    @Autowired
    private ReservaRepo reservaRepo;

    @Autowired
    ClienteRepo clienteRepo;

    @Autowired
    HabitacionRepo habitacionRepo;

    @Autowired
    EmailService emailService;

    @Override
    public Reserva agregarReserva(LocalDate fechaInicio, LocalDate fechaFinal, Integer cantidadDeClientes, List<Silla> sillas, List<Habitacion> habitaciones, Cliente cliente) throws Exception {

        if(fechaInicio.isBefore(fechaFinal)) {
            Reserva reserva = new Reserva(fechaInicio,fechaFinal,cantidadDeClientes, cliente);
            Double costoTotal = 0.0;
            Integer diasDeLaReserva = 0;

            if (!sillas.isEmpty()) {
                reserva.setVuelo(sillas.get(0).getVuelo());
                reserva.setSillas(sillas);
                Double costoSillas = 0.0;
                for (int i = 0; i < sillas.size(); i++) {
                    costoSillas += sillas.get(i).getValor();
                }
                costoTotal += costoSillas;
            }

            if (habitaciones.isEmpty()){
                throw new Exception("No hay habitaciones, por ende no se puede proceder con la reserva");
            } else {
                reserva.setHabitaciones(habitaciones);
                Double costoHabitaciones = 0.0;
                for (int i = 0; i < habitaciones.size(); i++) {
                    costoHabitaciones += habitaciones.get(i).getPrecio();
                }
                diasDeLaReserva = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFinal);

                costoTotal += costoHabitaciones * diasDeLaReserva;
                costoTotal += costoTotal + ((costoTotal*19)/100);
            }

            reserva.setCostoTotal(costoTotal);

            Reserva aux = reservaRepo.save(reserva);

            boolean envioDeCorreo = enviarCorreoConInformacionDeLaReserva(cliente.getEmail(), aux);

            if (envioDeCorreo == true) {
                return aux;
            } else {
                throw new Exception("Ha ocurrido un error con el registro de la reserva. Intentelo de nuevo.");
            }
        } else {
            throw new Exception("La fecha de inicio ingresada no es antes que la fecha final.");
        }

    }

    @Override
    public Reserva actualizarReserva(Integer codigo, LocalDate fechaInicio, LocalDate fechaFinal, Integer cantidadDeClientes, List<Silla> sillas, List<Habitacion> habitaciones, Cliente cliente) throws Exception {
        if(fechaInicio.isBefore(fechaFinal)) {
            if(reservaRepo.existsById(codigo)) {
                Reserva reserva = reservaRepo.getById(codigo);
                Double costoTotal = 0.0;
                Integer diasDeLaReserva = 0;

                reserva.setFechaInicio(fechaInicio);
                reserva.setFechaFinal(fechaFinal);
                reserva.setCliente(cliente);
                reserva.setCantidadDeClientes(cantidadDeClientes);

                if (!sillas.isEmpty()) {
                    reserva.setVuelo(sillas.get(0).getVuelo());
                    reserva.setSillas(sillas);
                    Double costoSillas = 0.0;
                    for (int i = 0; i < sillas.size(); i++) {
                        costoSillas += sillas.get(i).getValor();
                    }
                    costoTotal += costoSillas;
                }

                if (habitaciones.isEmpty()){
                    throw new Exception("No hay habitaciones, por ende no se puede proceder con la reserva");
                } else {
                    reserva.setHabitaciones(habitaciones);
                    Double costoHabitaciones = 0.0;
                    for (int i = 0; i < habitaciones.size(); i++) {
                        costoHabitaciones += habitaciones.get(i).getPrecio();
                    }
                    diasDeLaReserva = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFinal);

                    costoTotal += costoHabitaciones * diasDeLaReserva;
                }

                reserva.setCostoTotal(costoTotal);

                return reservaRepo.save(reserva);
            } else {
                throw new Exception("No existe una reserva con ese codigo.");
            }
        } else {
            throw new Exception("La fecha de inicio ingresada no es antes que la fecha final.");
        }
    }

    @Override
    public boolean eliminarReserva(Integer codigo) throws Exception {
        if(reservaRepo.existsById(codigo)) {
            reservaRepo.deleteById(codigo);
        } else {
            throw new Exception("No existe una reserva con ese codigo.");
        }
        if(reservaRepo.existsById(codigo)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Reserva buscarReservaPorCodigo(Integer codigo) throws Exception {
        if(reservaRepo.existsById(codigo)) {
            return reservaRepo.getById(codigo);
        } else {
            throw new Exception("No existe una reserva con ese codigo");
        }
    }

    @Override
    public List<Reserva> listar() throws Exception {
        return reservaRepo.findAll();
    }

    @Override
    public List<Reserva> listarReservaPorFechaDeInicio(LocalDate fechaInicio) throws Exception {
        return reservaRepo.listarReservaPorFechaInicio(fechaInicio);
    }

    @Override
    public List<Reserva> listarReservaPorFechaDeFinalizacion(LocalDate fechaFinal) throws Exception {
        return reservaRepo.listarReservaPorFechaFinal(fechaFinal);
    }

    @Override
    public List<Reserva> listarReservaPorIdDeCliente(String cedula) throws Exception {
        return reservaRepo.listarReservaPorIdDeCliente(cedula);
    }

    @Override
    public boolean enviarCorreoConInformacionDeLaReserva(String email, Reserva reserva) throws Exception {
        if(clienteRepo.findByEmail(email).isEmpty()) {
            throw new Exception("Este email no esta relacionado a algun cliente registrado en el sistema.");
        } else {
            String password = clienteRepo.recuperarPasswordConEmail(email);
            return emailService.enviarEmail("Reserva realizada!", "La informacion de su reserva es: " + reserva.toString(), email);

        }
    }

    @Override
    public List<Reserva> listarReservaPorHabitacion(Habitacion habitacion) throws Exception {
        if(habitacionRepo.findById(habitacion.getCodigo()).isPresent()) {
            return reservaRepo.listarReservaPorHabitacion(habitacion.getCodigo());
        } else {
            throw new Exception("No existe la habitacion indicada.");
        }
    }

}
