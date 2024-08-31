package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Contacto contacto1 = new Contacto("Daniel", "Dani", "Villa del carmen", "314578692", "daniel@gmail.com");
        Contacto contacto2 = new Contacto("Juan Esteban", "Juanes", "Videl carmen", "31458692", "daniel@gmail.com");
        Grupo grupo = new Grupo("Los traviesos", Categoria.AMIGOS);
        grupo.agregarContacto(contacto1);
        grupo.agregarContacto(contacto2);
        Contacto.mostrarMensaje(grupo.toString());

    }
}
