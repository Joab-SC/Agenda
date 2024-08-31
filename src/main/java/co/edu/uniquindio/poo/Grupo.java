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
            Contacto.mostrarMensaje("¡Error al ingresar un nuevo miembro, el grupo ya se llenó!");
        }
        else if(validarNombreTelefono(contacto.getNombre(), contacto.getTelefono())){
            Contacto.mostrarMensaje("¡Error!, el contacto " +contacto.getNombre()+ " con número de telefono: "+contacto.getTelefono()+ "ya está en el grupo");
        }
        else{
            contactos.add(contacto);
        }
    }

    public boolean validarNombreTelefono(String nombre, String telefono){
        boolean contactoRepetido = false;
        for(Contacto contacto: contactos){
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)){
                contactoRepetido = true;
                break;
            }
        }
        return contactoRepetido;
    }

    public void eliminarContacto(String nombre, String telfono){
        for(Contacto contacto: contactos){
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telfono)){
                contactos.remove(contacto);
                break;
            }
        }

    }

    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", categoria=" + categoria + ", contactos=" + contactos + "]";
    }

    


    
}
