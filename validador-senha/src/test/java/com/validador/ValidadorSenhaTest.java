package com.validador;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorSenhaTest {

    @Test
    void deveRetornarMultiplosErrosQuandoSenhaForFraca() {
        ResultadoValidacao resultado = ValidadorSenha.validar("mypass");

        assertFalse(resultado.isValido());
        List<String> erros = resultado.getErros();
        
        assertTrue(erros.contains("A senha deve ter pelo menos 8 caracteres"));
        assertTrue(erros.contains("A senha deve conter pelo menos 2 dígitos"));
        assertTrue(erros.contains("A senha deve conter pelo menos uma letra maiuscula"));
        assertTrue(erros.contains("A senha deve conter pelo menos um caractere especial"));
    }

    @Test
    void deveValidarComSucessoQuandoSenhaForForte() {
        ResultadoValidacao resultado = ValidadorSenha.validar("SenhaForte123!");

        assertTrue(resultado.isValido());
        assertTrue(resultado.getErros().isEmpty());
    }
}