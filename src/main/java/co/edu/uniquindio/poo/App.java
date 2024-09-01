package co.edu.uniquindio.poo;
import java.time.LocalTime;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Crear contactos
        Contacto contacto1 = new Contacto("Daniel", "Dani", "Villa del carmen", "314578692", "daniel@gmail.com");
        Contacto contacto2 = new Contacto("Juan Esteban", "Juanes", "Colinas", "31458692", "juan@gmail.com");
        Contacto contacto3 = new Contacto("Maria", "Mari", "Centro", "318785639", "maria@gmail.com");
        Contacto contacto4 = new Contacto("Sebastian", "Sebas", "Simon Bolivar", "34323596", "sebas@gmail.com");
        Contacto contacto5 = new Contacto("Maicol", "Mike", "CAM", "343453536", "maicol@hotmail.com");

        // Crear un grupo y agregar contactos
        Grupo grupo = new Grupo("Los traviesos", Categoria.AMIGOS);
        grupo.agregarContacto(contacto1);
        grupo.agregarContacto(contacto2);
        grupo.agregarContacto(contacto4);
        // Mostrar el grupo
        Contacto.mostrarMensaje(grupo.toString() + "\n\n");

        // Crear otro grupo y agregar contactos
        Grupo grupo2 = new Grupo("Familia Gomez", Categoria.FAMILIA);
        grupo2.agregarContacto(contacto1);
        grupo2.agregarContacto(contacto5);
        grupo2.agregarContacto(contacto3);
        // Mostrar el grupo
        Contacto.mostrarMensaje(grupo2.toString() + "\n\n");

        // Tratar de eliminar un contacto no existente
        grupo.eliminarContacto("Danilo", "314578692");

        // Eliminar un contacto del grupo
        grupo.eliminarContacto("Daniel", "314578692");

        //Mostrar el grupo sin el contacto
        Contacto.mostrarMensaje(grupo.toString() + "\n\n");

        

        // Crear una reunión
        Reunion reunion = new Reunion("Reunión de amigos", LocalDate.of(2024, 6, 20), LocalTime.of(12, 0));
        reunion.agregarAsistente(contacto1);
        reunion.agregarAsistente(contacto3);


        // Mostrar la reunión
        Contacto.mostrarMensaje(reunion.toString());

        // Eliminar un asistente de la reunion
        reunion.eliminarAsistente("Daniel", "314578692");

        // Mostrar la reunión
        Contacto.mostrarMensaje(reunion.toString());

        // Crear una agenda y agregar elementos
        Agenda agenda = new Agenda();
        agenda.agregarContacto(contacto1);
        agenda.agregarContacto(contacto2);
        agenda.agregarGrupo(grupo);
        agenda.agregarReunion(reunion);

        // Mostrar la agenda
        Contacto.mostrarMensaje(agenda.toString());

        // Eliminar un contacto y mostrar la agenda actualizada
        agenda.eliminarContacto("Juan Esteban", "31458692");
        Contacto.mostrarMensaje("Agenda después de eliminar un contacto:");
        Contacto.mostrarMensaje(agenda.toString());
    }
}

