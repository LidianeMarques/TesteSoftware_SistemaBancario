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
public class MovimentacaoTest {
    
    public MovimentacaoTest() {
    }

    @Test
    //Implementação do professor
    void testGetId() {
        final Movimentacao instance = new Movimentacao(new Conta());
        final long esperado = 1;
        instance.setId(esperado);
        final long obtido = instance.getId();
        assertEquals(esperado, obtido);
    }

    @Test
    public void testR1MovimentacaoTipoCredito() {
        final Movimentacao mov = new Movimentacao(new Conta());
        final Conta conta = new Conta();
        final double deposito = 500;
        conta.depositoDinheiro(deposito);
        final int posicaoUltimaMovimentacao = conta.getMovimentacoes().size() - 1;
        Movimentacao movimentacao = conta.getMovimentacoes().get(posicaoUltimaMovimentacao);
        assertTrue(movimentacao.getTipo() == 'C');
        System.out.println("R1_Saldo total da conta: " + conta.getSaldoTotal());
        System.out.println("R1_Tipo da movimentação: " + movimentacao.getTipo());
        System.out.println("Confirmação da movimentação: "+mov.isConfirmada());
    }

    @Test
    public void testR2MovimentacaoTipoDebito() {

        final Conta conta = new Conta();
        final double deposito = 700;
        conta.depositoDinheiro(deposito);
        System.out.println("R2_Saldo total da conta depois do deposito: " + conta.getSaldoTotal());
        conta.saque(200);
        final int posicaoUltimaMovimentacao = conta.getMovimentacoes().size() - 1;
        Movimentacao movimentacao = conta.getMovimentacoes().get(posicaoUltimaMovimentacao);
        assertTrue(movimentacao.getTipo() == 'D');
        System.out.println("R2_Saldo total da conta depois do saque: " + conta.getSaldoTotal());
        System.out.println("R2_Tipo da movimentação: " + movimentacao.getTipo());
    }

    @Test
    public void testR2part2MovimentacaoTipoDebito() {

        final Conta conta = new Conta();
        final double deposito = 100;
        final double valorEsperado = 40;
        conta.depositoDinheiro(deposito);
        conta.saque(60);
        final double valorObtido = conta.getSaldoTotal();
        assertEquals(valorEsperado, valorObtido);

    }

    @Test
    public void testR2part3MovimentacaoTipoDebitoContaEspecialTirandoDinheiroDoLimite() {

        final Conta conta = new Conta();
        final double limite = 500;
        final double deposito = 100;
        conta.setEspecial(true);
        conta.setLimite(limite);
        conta.depositoDinheiro(deposito);
        System.out.println("R2_pat3_Saldo total da conta depois do deposito: " + conta.getSaldoTotal());
        conta.saque(200);
        final int posicaoUltimaMovimentacao = conta.getMovimentacoes().size() - 1;
        Movimentacao movimentacao = conta.getMovimentacoes().get(posicaoUltimaMovimentacao);
        assertTrue(movimentacao.getTipo() == 'D');
        System.out.println("R2_pat3_Saldo total da conta depois do saque: " + conta.getSaldoTotal());
        System.out.println("R2_pat3_Limite da conta depois do saque: " + conta.getLimite());
        System.out.println("R2_pat3_Tipo da movimentação: " + movimentacao.getTipo());
    }

    @Test
    public void testR3part4MovimentacaoTipoDebitoSemDinheiro(){
        
        final Conta conta = new Conta();
        final double deposito = 100;
        conta.depositoDinheiro(deposito);
        assertThrows(IllegalArgumentException.class, () -> conta.saque(200.00));        
    }
    
    @Test
    public void testR04MovimentacoesIniciadasComConfirmadasComoPadrao() {
        final Movimentacao movimentacao = new Movimentacao(new Conta());
        //Para este teste passar o retorno da função isConfirmada tem que ser true.
        assertTrue(movimentacao.isConfirmada());
    }
    
    @Test
    public void test05ContaPassadaDeveSerArmazenadaNoAtributoConta(){
         final Movimentacao movimentacao = new Movimentacao(new Conta());
         assertNotNull(movimentacao.getConta());
    }
    
}
