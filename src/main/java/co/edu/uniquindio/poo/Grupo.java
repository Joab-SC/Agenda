package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.util.Scanner;

public class Grupo {
    private String nombre;
    private Categoria categoria;
    private ArrayList <Contacto> contactos;


    public Grupo(String nombre, Categoria categoria){
        this.nombre = nombre;
        this.categoria = categoria;
        contactos = new ArrayList<>();

        assert !nombre.isBlank();
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

    public void eliminarContacto(){
        Scanner scanner = new Scanner(System.in);

        Contacto.mostrarMensaje("Ingrese el nombre del contacto que desea eliminar: ");
        String nombre = scanner.nextLine();

        Contacto.mostrarMensaje("Ingrese el télefono del contacto que desea eliminar: ");
        String telefono = scanner.nextLine();



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

    public static Grupo ingresarGrupo(int numero){
        Scanner scanner = new Scanner(System.in);

        Contacto.mostrarMensaje("Ingresar el grupo número: " + numero + "\n");
        Contacto.mostrarMensaje("Ingrese el nombre del grupo: ");
        String nombre = scanner.nextLine();

        Categoria categoria;
        while (true){
            Contacto.mostrarMensaje("Ingrese la categoría del grupo (oficina, fiesta, amigos, familia): ");
            String cadenaCategoria = scanner.nextLine();

            if (cadenaCategoria.equals("oficina")){
                categoria = Categoria.OFICINA;
                break;

            } 
            else if(cadenaCategoria.equals("fiesta")){
                categoria = Categoria.FIESTA;
                break;
             }
            else if (cadenaCategoria.equals("amigos")){
                categoria = Categoria.AMIGOS;
                break;
            } 
            else if (cadenaCategoria.equals("familia")){
                categoria = Categoria.FAMILIA;
                break;
            } 

            else{
                Contacto.mostrarMensaje("La categoría no está entre las preseleccionadas");
            }   
        }

        Grupo grupo = new Grupo(nombre, categoria);

        return grupo;

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
