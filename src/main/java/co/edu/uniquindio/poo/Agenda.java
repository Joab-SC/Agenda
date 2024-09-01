package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> contactos;
    private ArrayList<Grupo> grupos;
    private ArrayList<Reunion> reuniones;

    public Agenda() {
        this.contactos = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.reuniones = new ArrayList<>();
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Reunion> getReuniones() {
        return reuniones;
    }

    public void setReuniones(ArrayList<Reunion> reuniones) {
        this.reuniones = reuniones;
    }



    public void agregarContacto(Contacto contacto) {
        if (!Grupo.validarNombreTelefono(contacto.getNombre(), contacto.getTelefono(), contactos)) {
            contactos.add(contacto);
        } else {
            Contacto.mostrarMensaje("¡Error intentar agregar un contacto! El contacto " + contacto.getNombre() + " ya existe en la agenda.");
        }
    }

    
    public void eliminarContacto(String nombre, String telefono) {
        boolean removed = false;
        for(Contacto contacto: contactos){
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                contactos.remove(contacto);
                removed = true;
                break;
            }
        }
        if (!removed){
            Contacto.mostrarMensaje("¡Error al intentar eliminar un contacto! El contacto " +nombre+ " no hace parte del grupo");
        }
    }
        

    public void agregarGrupo(Grupo grupo) {
        if (!validarNombreCategoria(grupo.getNombre(), grupo.getCategoria())){
            grupos.add(grupo);
        } else {
            Contacto.mostrarMensaje("¡Error al intentar agregar un grupo! Ya hay un grupo llamado " + grupo.getNombre() + "de la categoria" + grupo.getCategoria());
        }
    }


    public void eliminarGrupo(String nombre, Categoria categoria) {
        boolean removed = false;
        for(Grupo grupo: grupos){
            if (grupo.getNombre().equals(nombre) && grupo.getCategoria().equals(categoria)){
                grupos.remove(grupo);
                removed = true;
                break;
            }
        }
        if (!removed){
            Contacto.mostrarMensaje("¡Error al intentar eliminar un grupo! No existe una grupo llamado  " +nombre+ " de categoria " +categoria);
        }
    }


    public void agregarReunion(Reunion reunion) {
        if (!validarFechaHora(reunion.getFecha(), reunion.getHora())) {
            reuniones.add(reunion);
        } else {
            Contacto.mostrarMensaje("¡Error al agendar una reunión! Ya hay una reunión agendada  el " +reunion.getFecha().toString()+  " a las " +reunion.getHora());
        }
    }


    public void eliminarReunion(LocalDate fecha, LocalTime hora) {
        boolean removed = false;
        for(Reunion reunion: reuniones){
            if (reunion.getFecha().equals(fecha) && reunion.getHora().equals(hora)){
                reuniones.remove(reunion);
                removed = true;
                break;
            }
        }
        if (!removed){
            Contacto.mostrarMensaje("¡Error al intentar eliminar una reunión! No existe una reunión agendada el  " +fecha+ " a las " +hora);
        }
    }


    public  boolean validarFechaHora(LocalDate fecha, LocalTime hora){
        boolean reunionRepetida = false;
        for(Reunion reunion: reuniones){
            if (reunion.getFecha().equals(fecha) && reunion.getHora().equals(hora)){
                reunionRepetida = true;
                break;
            }
        }
        return reunionRepetida;
    }

    
    public boolean validarNombreCategoria(String nombre, Categoria categoria){
        boolean grupoRepetido = false;
        for (Grupo grupo: grupos){
            if(grupo.getNombre().equals(nombre) && grupo.getCategoria().equals(categoria)){
                grupoRepetido = true;
                break;
            }
        }
        return grupoRepetido;
    }




    @Override
    public String toString() {
        return "Agenda:\n\n" +
               "Contactos:\n" +
               contactos.stream()
                        .map(contacto -> "  - " + contacto.getNombre() + " (" + contacto.getAlias() + ")\n")
                        .reduce("", String::concat) +
               "\n\nGrupos:\n" +
               grupos.stream()
                     .map(Grupo::toString)
                     .reduce("", String::concat) +
               "\n\nReuniones:\n" +
               reuniones.stream()
                        .map(Reunion::toString)
                        .reduce("", String::concat);
    }
    
}
