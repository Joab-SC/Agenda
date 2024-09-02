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
import java.time.LocalDate;
import java.time.LocalTime;



/**
 * Unit test for simple App.
 */
public class ReunionTest {
    private static final Logger LOG = Logger.getLogger(ContactoTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void descripcioVacia() {
        LOG.info("Iniciado test descripción vacía");

        assertThrows(Throwable.class, () -> new Reunion(" ", LocalDate.of(2025, 9, 20), LocalTime.of(12, 0, 0)));

        LOG.info("Finalizando test descripción vacía");
    }

    @Test
    public void fechaInvalida(){
        LOG.info("Iniciando test fecha inválida");

        assertThrows(Throwable.class, () -> new Reunion("Reunión para hacer la tarea", LocalDate.of(2014, 9, 2), LocalTime.of(13, 15, 5)));

        LOG.info("Finalizando test fecha inválida");
    }

}
