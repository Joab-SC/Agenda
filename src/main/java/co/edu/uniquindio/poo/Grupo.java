package co.edu.uniquindio.poo;
import java.util.ArrayList;

public class Grupo {
    private String nombre;
    private Categoria categoria;
    private ArrayList <Contacto> contactos;

    public Grupo(String nombre, Categoria categoria){
        this.nombre = nombre;
        this.categoria = categoria;
        contactos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public void agregarContacto(Contacto contacto){
        if (contactos.size() == 5){
            Contacto.mostrarMensaje("¡Error al agregar un nuevo contacto al grupo" +nombre+ "! El grupo ya se llenó!");
        }
        else if(validarNombreTelefono(contacto.getNombre(), contacto.getTelefono(), contactos)){
            Contacto.mostrarMensaje("¡Error al agregar un nuevo contacto al grupo" +nombre+ "! El contacto " +contacto.getNombre()+ " con número de teléfono: "+contacto.getTelefono()+ "ya está en el grupo");
        }
        else{
            contactos.add(contacto);
        }
    }

    public static boolean validarNombreTelefono(String nombre, String telefono, ArrayList<Contacto> contactos){
        boolean contactoRepetido = false;
        for(Contacto contacto: contactos){
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                contactoRepetido = true;
                break;
            }
        }
        return contactoRepetido;
    }

    public void eliminarContacto(String nombre, String telefono){
        boolean removed = false;
        for(Contacto contacto: contactos){
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                contactos.remove(contacto);
                removed = true;
                break;
            }
        }
        if (!removed){
            Contacto.mostrarMensaje("¡Error al eliminar un contacto del grupo " +this.nombre + "! El contacto " +nombre+ " no hace parte del grupo");
        }
    }

    
    @Override
    public String toString() {
        return "Grupo: " + nombre + "\n" +
               "Categoría: " + categoria + "\n" +
               "Contactos:\n" +
               contactos.stream()
                        .map(contacto -> "  - " + contacto.getNombre() + " (" + contacto.getAlias() + ")\n")
                        .reduce("", String::concat);
    }
    
 
}
