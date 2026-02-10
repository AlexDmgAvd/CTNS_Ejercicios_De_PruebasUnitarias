package ejercicio02;

import ejercicio01.NormalizadorNombreCompleto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidadorContrasenaTest {

    private ValidadorContrasena validador;

    @BeforeEach
    public void setUp(){
        validador = new ValidadorContrasena();
    }

    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaValida_SalidaDeUnaContrasenhaValida(){

        String Contrasenha = "HolaMundo1!";
        assertTrue(validador.isValid(Contrasenha));
    }



    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaMuyCorta_SalidaDaUnFalse(){

        String Contrasenha = "HolaM!";
        assertFalse(validador.isValid(Contrasenha));
    }

    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaSinMayuscula_SalidaDaUnFalse(){

        String Contrasenha = "holamundo1!";
        assertFalse(validador.isValid(Contrasenha));
    }

    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaSinMinuscula_SalidaDaUnFalse(){

        String Contrasenha = "HOLAMUNDO1!";
        assertFalse(validador.isValid(Contrasenha));
    }

    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaSinDigito_SalidaDaUnFalse(){

        String Contrasenha = "holamundo!";
        assertFalse(validador.isValid(Contrasenha));
    }

    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaSinSimbolo_SalidaDaUnFalse(){

        String Contrasenha = "holamundo1";
        assertFalse(validador.isValid(Contrasenha));
    }

    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaValidaDe8Caracteres_SalidaDeUnaContrasenhaValida(){

        String Contrasenha = "HolaMu1!";
        assertTrue(validador.isValid(Contrasenha));
    }

    @Test
    public void ValidadorContrasenaTest_entradaDeUnaContrasenhaConEspacios_SalidaDaUnFalse(){

        String Contrasenha = "Hola Mundo1!";
        assertFalse(validador.isValid(Contrasenha));
    }


}
