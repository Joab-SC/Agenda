package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reunion {
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private ArrayList<Contacto> asistentes;

    public Reunion(String descripcion, LocalDate fecha, LocalTime hora) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.asistentes = new ArrayList<>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public ArrayList<Contacto> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(ArrayList<Contacto> asistentes) {
        this.asistentes = asistentes;
    }

    public void agregarAsistente(Contacto contacto) {
        if (Grupo.validarNombreTelefono(contacto.getNombre(), contacto.getTelefono(), asistentes)) {
            Contacto.mostrarMensaje("¡El contacto " + contacto.getNombre() +" ya está en la lista de asistentes de la reunión!");
            
        } else {
            asistentes.add(contacto);
        }
    }


    public void eliminarAsistente(String nombre, String telfono){
        boolean removed = false;
        for(Contacto contacto: asistentes){
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telfono)){
                asistentes.remove(contacto);
                removed = true;
                break;
            }
        }
        if (!removed){
            Contacto.mostrarMensaje("!Error al ingresar un assistente a la reunión " + descripcion + "! El asistente " +nombre+ " no hace parte de la reunión");
        }
    }


    @Override
    public String toString() {
        return "Reunión: " + descripcion + "\n" +
               "Fecha: " + fecha.toString() + " Hora: " + hora.toString() + "\n" +
               "Asistentes:\n" +
               asistentes.stream()
                         .map(contacto -> "  - " + contacto.getNombre() + " (" + contacto.getAlias() + ")\n")
                         .reduce("", String::concat);
    }
    
}
