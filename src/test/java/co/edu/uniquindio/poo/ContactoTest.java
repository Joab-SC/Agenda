/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;



/**
 * Unit test for simple App.
 */
public class ContactoTest {
    private static final Logger LOG = Logger.getLogger(ContactoTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void datosVacios() {
        LOG.info("Iniciado test datos vacíos");

        assertThrows(Throwable.class, () -> new Contacto(" ", " ", " ", " ", " "));

        LOG.info("Finalizando test datos vacíos de contacto");
    }

    @Test
    public void correoValido() {
        LOG.info("Iniciado test de correo valido");

        assertThrows(Throwable.class, () -> new Contacto("Luis", "Lucho", "Villa alejandra", "318720909", "luis.arboleda.gmail.com"));

        LOG.info("Finalizando test correo valido");
    }

    @Test
    public void numeroValido() {
        LOG.info("Iniciado test de correo valido");

        assertThrows(Throwable.class, () -> new Contacto("Luis", "Lucho", "Villa alejandra", "hola", "luis.arboleda@gmail.com"));

        LOG.info("Finalizando test de número valido");
    }
}