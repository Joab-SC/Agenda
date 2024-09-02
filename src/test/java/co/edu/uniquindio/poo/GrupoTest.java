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
public class GrupoTest {
    private static final Logger LOG = Logger.getLogger(ContactoTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void nombreVacio() {
        LOG.info("Iniciado test nombre vacío");

        assertThrows(Throwable.class, () -> new Grupo(" ", Categoria.AMIGOS));

        LOG.info("Finalizando test datos nombre vacío");
    }

}
