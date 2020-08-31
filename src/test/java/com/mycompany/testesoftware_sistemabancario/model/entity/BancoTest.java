/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testesoftware_sistemabancario.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lidiane
 */
public class BancoTest {

    public BancoTest() {
    }

    @Test
    public void testR01TresAlgarismos() {
        Banco banco = new Banco();
        final String numeroInvalido = "1234";
        assertThrows(IllegalArgumentException.class, () -> banco.setNumero(numeroInvalido));

    }

    @Test
    public void testR02SomenteNumeros() {
        Banco banco = new Banco();
        final String numeroInvalido = "abc";
        assertThrows(IllegalArgumentException.class, () -> banco.setNumero(numeroInvalido));

    }

}
