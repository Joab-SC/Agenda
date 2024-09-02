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
        LOG.info("Iniciado test de la función agregarReunion");
        Reunion reunion = new Reunion("Reunión para hablar de negocios", LocalDate.of(2030, 12, 1), LocalTime.of(10, 0));
        agenda.agregarReunion(reunion);
        assertTrue(agenda.getReuniones().contains(reunion));
        LOG.info("Finalizando test de la función agregarReunion");
    }

    @Test
    public void testAgregarContacto() {
        LOG.info("Iniciado test de la función agregarContacto");
        Contacto contacto = new Contacto("Andres", "Andy", "La castilla", "34909234", "andyl@gmail.com");
        agenda.agregarContacto(contacto);
        assertTrue(agenda.getContactos().contains(contacto));
        LOG.info("Finalizando test de la función agregarContacto");
    }

    @Test
    public void testAgregarGrupo() {
        LOG.info("Iniciado test de la función agregarGrupo");
        Grupo grupo = new Grupo("Asesores comerciales", Categoria.OFICINA);
        agenda.agregarGrupo(grupo);
        assertTrue(agenda.getGrupos().contains(grupo));
        LOG.info("Finalizando test de la función agregarGrupo");
    }


    @Test
    public void testEliminarContacto() {
        LOG.info("Iniciado test de la función eliminarContacto");
        Contacto contacto = new Contacto("Francisco", "Pacho", "El granada", "309019289", "pachito@gmail.com");
        agenda.agregarContacto(contacto);
        agenda.eliminarContacto("Francisco", "309019289");
        assertFalse(agenda.getContactos().contains(contacto));
        LOG.info("Finalizando test de la función eliminarContacto");
    }

    @Test
    public void testEliminarReunion() {
        LOG.info("Iniciado test de la función eliminarReunion");
        Reunion reunion = new Reunion("Reunion de negocios", LocalDate.of(2030, 12, 31), LocalTime.of(12, 30, 0));
        agenda.agregarReunion(reunion);
        agenda.eliminarReunion(LocalDate.of(2030, 12, 31), LocalTime.of(12, 30, 0));
        assertFalse(agenda.getReuniones().contains(reunion));
        LOG.info("Finalizando test de la función eliminarReunion");
    }

    @Test
    public void testEliminarGrupo() {
        LOG.info("Iniciado test de la función eliminarGrupo");
        Grupo grupo = new Grupo("Asesores comerciales", Categoria.OFICINA);
        agenda.agregarGrupo(grupo);
        agenda.eliminarGrupo("Asesores comerciales", Categoria.OFICINA);
        assertFalse(agenda.getGrupos().contains(grupo));
        LOG.info("Finalizando test de la función eliminarGrupo");
    }

}