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
public class ClienteTest {

    public ClienteTest() {
    }

    @Test
    public void testR01CpfNulo() {
        final Cliente cliente = new Cliente();
        assertThrows(NullPointerException.class, () -> cliente.setCpf(null));
    }

    @Test
    public void testR01CpfVazio() {
        final Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class, () -> cliente.setCpf(""));
    }

    @Test
    public void testR01SomenteNumeros() {
        final Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class, () -> cliente.setCpf("802.506.710-69"));
    }

    @Test
    public void testR02CpfInvalido() {
        final Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class, () -> cliente.setCpf("80250671000"));
    }

    @Test
    public void testR02CpfValido() {
        final Cliente cliente = new Cliente();
        final String valorEsperado = "80250671069";
        cliente.setCpf(valorEsperado);
        assertEquals(valorEsperado, cliente.getCpf());
    }

    @Test
    public void testR03NomeNulo() {
        final Cliente cliente = new Cliente();
        assertThrows(NullPointerException.class, () -> cliente.setNome(null));
    }

    @Test
    public void testR03NomeVazio() {
        final Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class, () -> cliente.setNome(""));
    }

    @Test
    public void testR03NomeComEspaco() {
        final Cliente cliente = new Cliente();
        assertThrows(IllegalArgumentException.class, () -> cliente.setNome(" "));
    }

    @Test
    public void testR04NomeSemSobrenome() {
        final Cliente cliente = new Cliente();

        assertThrows(IllegalArgumentException.class, () -> cliente.setNome("Maria"));
    }

}
