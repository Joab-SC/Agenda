/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;



/**
 * Unit test for simple App.
 */
public class AgendaTest {
    private Agenda agenda;
    private static final Logger LOG = Logger.getLogger(ContactoTest.class.getName());

    /**
     * Rigorous Test :-)
     */

    @BeforeEach
    public void setUp() {
        agenda = new Agenda();
    }


    @Test
    public void testAgregarReunion() {
        Reunion reunion = new Reunion("Reunión para hablar de negocios", LocalDate.of(2030, 12, 1), LocalTime.of(10, 0));
        agenda.agregarReunion(reunion);
        assertTrue(agenda.getReuniones().contains(reunion));
    }

    @Test
    public void testAgregarContacto() {
        Contacto contacto = new Contacto("Andres", "Andy", "La castilla", "34909234", "andyl@gmail.com");
        agenda.agregarContacto(contacto);
        assertTrue(agenda.getContactos().contains(contacto));
    }

    @Test
    public void testAgregarGrupo() {
        Grupo grupo = new Grupo("Asesores comerciales", Categoria.OFICINA);
        agenda.agregarGrupo(grupo);
        assertTrue(agenda.getGrupos().contains(grupo));
    }


    @Test
    public void testEliminarContacto() {
        Contacto contacto = new Contacto("Francisco", "Pacho", "El granada", "309019289", "pachito@gmail.com");
        agenda.agregarContacto(contacto);
        agenda.eliminarContacto("Francisco", "309019289");
        assertFalse(agenda.getContactos().contains(contacto));
    }

    @Test
    public void testEliminarReunion() {
        Reunion reunion = new Reunion("Reunion de negocios", LocalDate.of(2030, 12, 31), LocalTime.of(12, 30, 0));
        agenda.agregarReunion(reunion);
        agenda.eliminarReunion(LocalDate.of(2030, 12, 31), LocalTime.of(12, 30, 0));
        assertFalse(agenda.getReuniones().contains(reunion));
    }

    @Test
    public void testEliminarGrupo() {
        Grupo grupo = new Grupo("Asesores comerciales", Categoria.OFICINA);
        agenda.agregarGrupo(grupo);
        agenda.eliminarGrupo("Asesores comerciales", Categoria.OFICINA);
        assertFalse(agenda.getGrupos().contains(grupo));
    }

}