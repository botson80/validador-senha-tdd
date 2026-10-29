package com.validador;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenha {

    public static ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();

        if (senha == null || senha.length() < 8) {
            erros.add("A senha deve ter pelo menos 8 caracteres");
        }

        long quantidadeDigitos = senha != null ? senha.chars().filter(Character::isDigit).count() : 0;
        if (quantidadeDigitos < 2) {
            erros.add("A senha deve conter pelo menos 2 dígitos");
        }

        boolean temMaiuscula = senha != null && senha.chars().anyMatch(Character::isUpperCase);
        if (!temMaiuscula) {
            erros.add("A senha deve conter pelo menos uma letra maiuscula");
        }

        boolean temEspecial = senha != null && senha.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        if (!temEspecial) {
            erros.add("A senha deve conter pelo menos um caractere especial");
        }

        boolean valido = erros.isEmpty();
        return new ResultadoValidacao(valido, erros);
    }
}