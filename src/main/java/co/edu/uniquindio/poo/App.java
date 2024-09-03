package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        //crear la agenda
    Agenda agenda = new Agenda();

    //agregar contactos
    Contacto contacto1 = Contacto.ingresarContacto(1);
    Contacto contacto2 = Contacto.ingresarContacto(2);

        
    //agregar grupos
    Grupo grupo1 = Grupo.ingresarGrupo(1);


    //agregar reuniones 
    Reunion reunion1 = Reunion.ingresarReunion(1);

    //agregar a la agenfa
    agenda.agregarGrupo(grupo1);
    agenda.agregarContacto(contacto1);
    agenda.agregarContacto(contacto2);
    agenda.agregarReunion(reunion1);


    Contacto.mostrarMensaje(agenda.toString());


    Contacto.mostrarMensaje("Agenda con contactos en los grupos\n");

    //agregar contactos grupo
    grupo1.agregarContacto(contacto2);
    grupo1.agregarContacto(contacto1);


    Contacto.mostrarMensaje(agenda.toString());


    //Agregar asistentes a la reunion
    reunion1.agregarAsistente(contacto1);
    reunion1.agregarAsistente(contacto2);

    Contacto.mostrarMensaje("Agenda con asistentes en las reuniones\n");

    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar contactos del grupo
    Contacto.mostrarMensaje("Eliminar asistente de la reunión\n");
    reunion1.eliminarAsistente();

    Contacto.mostrarMensaje(agenda.toString());


    // Tratar de elimnar contactos inexistentes
    Contacto.mostrarMensaje("Tratar de eliminar contactos inexistentes\n");
    agenda.eliminarContacto();

    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar una reunion completa de la agenda
    Contacto.mostrarMensaje("Eliminar una reunión de la agenda\n");
    agenda.eliminarReunion();

    
    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar un contacto de la agenda
    Contacto.mostrarMensaje("Eliminar un contacto de la agenda\n");
    agenda.eliminarContacto();

    
    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar un grupo de la agenda
    Contacto.mostrarMensaje("Eliminar un grupo de la agenda\n");
    agenda.eliminarGrupo();
    
    Contacto.mostrarMensaje(agenda.toString());





    }
}

