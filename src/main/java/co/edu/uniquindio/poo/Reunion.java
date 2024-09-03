package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

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

        assert !descripcion.isBlank();
        assert !fecha.isBefore(LocalDate.now());
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


    public void eliminarAsistente(){
        Scanner scanner = new Scanner(System.in);

        Contacto.mostrarMensaje("Ingrese el nombre del asistente que desea eliminar: ");
        String nombre = scanner.nextLine();

        Contacto.mostrarMensaje("Ingrese el télefono del asistente que desea eliminar: ");
        String telefono = scanner.nextLine();

        boolean removed = false;
        for(Contacto contacto: asistentes){
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                asistentes.remove(contacto);
                removed = true;
                break;
            }
        }
        if (!removed){
            Contacto.mostrarMensaje("!Error al ingresar un assistente a la reunión " + descripcion + "! El asistente " +nombre+ " no hace parte de la reunión");
        }
    }


    public static Reunion ingresarReunion(int numero){
        Scanner scanner = new Scanner(System.in);

        Contacto.mostrarMensaje("Ingresar la reunión número " + numero + "\n");
        Contacto.mostrarMensaje("Ingrese la descripción de la reunión: ");
        String descripcion = scanner.nextLine();

        Contacto.mostrarMensaje("Ingrese el año de la reunión: ");
        int año = scanner.nextInt();

        Contacto.mostrarMensaje("Ingrese el mes de la reunión: ");
        int mes = scanner.nextInt();

        Contacto.mostrarMensaje("Ingrese el dia de la reunión: ");
        int dia = scanner.nextInt();

        Contacto.mostrarMensaje("Ingrese hora de la reunión: ");
        int hora = scanner.nextInt();

        Contacto.mostrarMensaje("Ingrese el minuto de la reunión: ");
        int minuto = scanner.nextInt();

        Reunion reunion = new Reunion(descripcion, LocalDate.of(año, mes, dia), LocalTime.of(hora, minuto));
        return reunion;

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
