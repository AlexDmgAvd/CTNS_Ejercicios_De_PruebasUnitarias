package ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.*;
public class NormalizadorNombreCompletoTest {


    /**
     * Objetivo: Probar un método que normaliza nombres y apellidos recibidos como texto.
     *
     *     Reglas
     *
     *     Entrada: String.
     *      Salida: String con:
     *     trim() aplicado.
     *     Múltiples espacios internos colapsados a uno.
     *     Cada palabra en formato Capitalized (primera letra mayúscula, resto minúsculas).
     *     Si raw es null: lanzar IllegalArgumentException.
     *     Si tras normalizar queda vacío: lanzar IllegalArgumentException.
     *
     *     Checklist de tests
     *
     *     Devuelve el mismo resultado para un nombre ya normalizado.
     *     Recorta espacios al inicio y al final.
     *     Colapsa múltiples espacios internos.
     *     Convierte "mARiA jOSE" a "Maria Jose".
     *     Mantiene palabras con una sola letra ("a b" → "A B").
     *     Lanza excepción con null.
     *     Lanza excepción con " " (solo espacios).
     */

    private NormalizadorNombreCompleto normalizador;

    @BeforeEach
    public void setUp(){
        normalizador = new NormalizadorNombreCompleto();
    }

    @Test
    public void NormalizadorNombreCompletoTest_entradaDeUnaCadena_salidaDeUnaCadena(){

        var normalizador = new NormalizadorNombreCompleto();
        String textoAProbar = "Hola";
        String textoBueno = normalizador.normalize(textoAProbar);
        String textoFinal = "Hola";
        assertEquals(textoFinal,textoBueno);

    }

    @Test
    public void NormalizadorNombreCompletoTest_entradaDeUnaCadenaConEspacios_salidaDeUnaCadenaSinEspacios(){

        var normalizador = new NormalizadorNombreCompleto();
        String textoAProbar = " Hola ";
        String textoBueno = normalizador.normalize(textoAProbar);
        String textoFinal = "Hola";
        assertEquals(textoFinal,textoBueno);
    }

    @Test
    public void  NormalizadorNombreCompletoTest_entradaDeUnaCadenaConMuchosEspaciosEntrePalabras_salidaDeUnaCadenaSinEspaciosEntrePalabras(){

        var normalizador = new NormalizadorNombreCompleto();
        String textoAProbar = "Texto                       Prueba";
        String textoBueno = normalizador.normalize(textoAProbar);
        String textoFinal = "Texto Prueba";
        assertEquals(textoFinal,textoBueno);

    }

    @Test
    public void  NormalizadorNombreCompletoTest_entradaDeUnaCadenaConMuchasMayusculasErroneas_salidaDeUnaCadenaSinMayusculasErroneas(){

        var normalizador = new NormalizadorNombreCompleto();
        String textoAProbar = "mARiA jOSE";
        String textoBueno = normalizador.normalize(textoAProbar);
        String textoFinal = "Maria Jose";
        assertEquals(textoFinal,textoBueno);

    }

    @Test
    public void  NormalizadorNombreCompletoTest_entradaDeUnaCadenaConUnaSolaLetra_salidaDeUnaCadenaConUnaSolaLetraCapitalizada(){

        var normalizador = new NormalizadorNombreCompleto();
        String textoAProbar = "a b";
        String textoBueno = normalizador.normalize(textoAProbar);
        String textoFinal = "A B";
        assertEquals(textoFinal,textoBueno);
    }

    @Test
    public void  NormalizadorNombreCompletoTest_entradaDeUnNull_salidaLanzaUnaExcepcionDeNull(){

        try{
            new NormalizadorNombreCompleto().normalize(null);
            fail();
        }catch (IllegalArgumentException e){
            assertTrue(true);
        }

//        assertThrows(IllegalArgumentException.class,
//                () -> new NormalizadorNombreCompleto().normalize("null"));
    }

    @Test
    public void NormalizadorNombreCompletoTest_entradaDeEspaciosEnBlanco_salidaLanzaUnaExcepcionDeEspaciosEnBlanco(){

        assertThrows(IllegalArgumentException.class,
                () -> new NormalizadorNombreCompleto().normalize(" "));
    }
}
