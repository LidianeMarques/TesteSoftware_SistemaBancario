/*
 *Apresenta um projeto com um conjunto de classes contendo documentação JavaDoc 
 *detalhando quais requisitos devem ser implementados para as classes e métodos 
 *disponibilizados.
 *Os métodos possuem apenas a estrutura, sendo que a implementação deve ser 
 *desenvolvida pelo aluno, seguindo o processo TDD.
 *Implementar os requisitos R01 a R04 para a classe Conta. Disponibilizar link 
 *para novo repositório exclusivo para o projeto no GitHub.
 */
package com.mycompany.testesoftware_sistemabancario.model.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lidiane
 */
public class ContaTest {

    /**
     * Implementar requisitos do vídeo #1 do Sistema Bancário; 
     * Implementar os requisitos R01 a R04 para a classe Conta; 
     * (R01).
     */
    @Test
    public void testR01SetNumeroValido() {
        final Conta instance = new Conta();
        final String numeroEsperado = "12345-6";
        instance.setNumero(numeroEsperado);
        final String valorObtido = instance.getNumero();
        assertEquals(numeroEsperado, valorObtido);
    }

    @Test
    public void testR01NumeroInvalidoExcecao() {
        final Conta instance = new Conta();
        final String numeroInvalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(numeroInvalido));
    }

    @Test
    public void testR01NumeroInvalidoNaoArmazena() {
        final Conta instance = new Conta();
        final String numeroInvalido = "123";
        assertThrows(IllegalArgumentException.class, () -> instance.setNumero(numeroInvalido));
        // instance.setNumero(numeroInvalido);
        final String valorObtido = instance.getNumero();
        //assertNotEquals é para saber se o valor armazenado não é igual ao numeroInvalido
        assertNotEquals(numeroInvalido, valorObtido);
    }
    /**#Desafio do professor:
     * Teste para verificar se o parametro passado é nulo.
     */
    @Test
    public void testR01NumeroNulo(){
        final Conta instance = new Conta();
        assertThrows(NullPointerException.class, () -> instance.setNumero(null));
    }

     /**
     * Implementar requisitos do vídeo #1 do Sistema Bancário; 
     * Implementar os requisitos R01 a R04 para a classe Conta; 
     * (R02);
     * Contas devem ser instanciadas como "Conta Corrente" e não como
     * "Poupança".
     * 
     */
    @Test
    public void testR02InstanciaPadraoPoupanca(){
        final Conta instance = new Conta();
        //Para este teste passar o retorno da função isPoupanca tem que ser falso.
        assertFalse(instance.isPoupanca());
        
    }
    
    /**
     * Implementar requisitos do vídeo #1 do Sistema Bancário; 
     * Implementar os requisitos R01 a R04 para a classe Conta; 
     * (R03);
     * Somente contas especiais podem ter limite, ou seja, o limite
     * de contas "não especiais" não pode ser maior que zero.
     */
    @Test
    public void testR03SetLimiteContaEspecial(){
        final Conta instance = new Conta();
        instance.setEspecial(true);
        final double valorEsperado = 1000;
        instance.setLimite(valorEsperado);
        final double valorObtido = instance.getLimite();
        assertEquals(valorEsperado, valorObtido);
    }
    
    @Test
    public void testR03SetLimiteContaNaoEspecial(){    
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
    }
    /**#Desafio do professor:
     * Verificar se o limete não foi alterado.
     */
    @Test
    public void testR03LimiteContaNaoEspecialNaoAlterado(){
        final Conta instance = new Conta();
        final double limite = 1000;
        assertThrows(IllegalStateException.class, () -> instance.setLimite(limite));
        final String valorObtido = instance.getNumero();
        //assertNotEquals é para saber se o valor armazenado não é igual ao limite
        assertNotEquals(limite, valorObtido);            
    }
    
    /**
     * Implementar requisitos do vídeo #1 do Sistema Bancário; 
     * Implementar os requisitos R01 a R04 para a classe Conta; 
     * (R04);
     * Um teste deve verificar se, após instanciar uma
     * conta usando qualquer um dos construtores, a lista de movimentações não é
     * nula, chamando o método.
     */
    @Test
    public void testR04HistoricoNotNull(){
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }
    
}
