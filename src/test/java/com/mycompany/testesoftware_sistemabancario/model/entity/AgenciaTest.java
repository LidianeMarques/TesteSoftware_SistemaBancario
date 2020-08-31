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
public class AgenciaTest {

    public AgenciaTest() {
    }

    @Test
    public void testR01BancoNaoNulo() {
        final Agencia agencia = new Agencia(new Banco());
        assertNotNull(agencia.getBanco());
    }

    @Test
    public void testR02NumeroNulo() {
        final Agencia agencia = new Agencia(new Banco());
        assertThrows(NullPointerException.class, () -> agencia.setNumero(null));
    }

    @Test
    public void testR02NumeroVazio() {
        final Agencia agencia = new Agencia(new Banco());
        assertThrows(IllegalArgumentException.class, () -> agencia.setNumero(""));
    }

    @Test
    public void testR03NumeroValidoSemTraco() {
        final Agencia agencia = new Agencia(new Banco());
        assertThrows(IllegalArgumentException.class, () -> agencia.setNumero("06386"));
    }

    @Test
    public void testR04NumeroInvalidoComTraco() {
        final Agencia agencia = new Agencia(new Banco());
        assertThrows(IllegalArgumentException.class, () -> agencia.setNumero("0638-0"));
    }

    @Test
    public void testR04NumeroValidoComTraco() {
        final Agencia agencia = new Agencia(new Banco());
        final String numeroValidoEspeprado = "0638-6";
        agencia.setNumero(numeroValidoEspeprado);
        assertEquals(numeroValidoEspeprado, agencia.getNumero());
    }

}
