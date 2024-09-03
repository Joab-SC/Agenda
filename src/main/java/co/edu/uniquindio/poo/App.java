package co.edu.uniquindio.poo;

import javax.naming.ldap.ControlFactory;

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
    Contacto contacto3 = Contacto.ingresarContacto(3);
    Contacto contacto4 = Contacto.ingresarContacto(4);
    Contacto contacto5 = Contacto.ingresarContacto(5);
    Contacto contacto6= Contacto.ingresarContacto(6);  
        
    //agregar grupos
    Grupo grupo1 = Grupo.ingresarGrupo(1);
    Grupo grupo2 = Grupo.ingresarGrupo(2);
    Grupo grupo3 = Grupo.ingresarGrupo(3);

    //agregar reuniones 
    Reunion reunion1 = Reunion.ingresarReunion(1);
    Reunion reunion2 = Reunion.ingresarReunion(2);
    Reunion reunion3 = Reunion.ingresarReunion(3);

    //agregar a la agenfa
    agenda.agregarGrupo(grupo1);
    agenda.agregarGrupo(grupo2);
    agenda.agregarGrupo(grupo3);
    agenda.agregarContacto(contacto1);
    agenda.agregarContacto(contacto2);
    agenda.agregarContacto(contacto3);
    agenda.agregarContacto(contacto4);
    agenda.agregarContacto(contacto5);
    agenda.agregarContacto(contacto6);
    agenda.agregarReunion(reunion1);
    agenda.agregarReunion(reunion2);
    agenda.agregarReunion(reunion3);

    Contacto.mostrarMensaje(agenda.toString());

    //agregar contactos grupo
    grupo1.agregarContacto(contacto2);
    grupo1.agregarContacto(contacto6);
    grupo2.agregarContacto(contacto4);
    grupo2.agregarContacto(contacto1);
    grupo3.agregarContacto(contacto3);
    grupo3.agregarContacto(contacto5);

    Contacto.mostrarMensaje(agenda.toString());

    //Agregar asistentes a la reunion
    reunion1.agregarAsistente(contacto1);
    reunion1.agregarAsistente(contacto2);
    reunion2.agregarAsistente(contacto3);
    reunion2.agregarAsistente(contacto4);
    reunion3.agregarAsistente(contacto5);
    reunion3.agregarAsistente(contacto6);

    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar contactos del grupo
    grupo2.eliminarContacto();
    reunion1.eliminarAsistente();

    Contacto.mostrarMensaje(agenda.toString());


    // Tratar de elimnar contactos inexistentes
    agenda.eliminarContacto();

    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar una reunion completa de la agenda
    agenda.eliminarReunion();

    
    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar un contacto de la agenda
    agenda.eliminarContacto();

    
    Contacto.mostrarMensaje(agenda.toString());

    // Eliminar un grupo de la agenda
    agenda.eliminarGrupo();
    
    Contacto.mostrarMensaje(agenda.toString());





    }
}

