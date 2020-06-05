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
     * Código prof vídeo-aula#1
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
    
    /**vídeo #1 do Sistema Bancário
     * #Desafio do professor:
     * Teste para verificar se o parametro passado é nulo.
     * Minha implementação
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
     * Código prof vídeo-aula#1 
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
     * Código prof vídeo-aula#1
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
    /**vídeo #1 do Sistema Bancário
     * #Desafio do professor:
     * Verificar se o limete não foi alterado.
     * Minha implementação
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
     * Código prof vídeo-aula#1
     */
    @Test
    public void testR04HistoricoNotNull(){
        final Conta instance = new Conta();
        assertNotNull(instance.getMovimentacoes());
    }
    
    /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números 
     * double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário.
     * Método getSaldoTotal
     * Código prof vídeo-aula#2.
     */
    @Test
    public void testGetSaldoTotal(){
        final double limite = 500;
        final double valorEsperado = limite;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        final double valorObtido = instance.getSaldoTotal();
        assertEquals(valorEsperado, valorObtido);        
    }
    
    /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números 
     * double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário.
     * Método depositoDinheiro
     * Código prof vídeo-aula#2.
     */
    @Test
    public void testDepositoDinheiro(){
        final double limite = 500.6;
        final double deposito = 500.8;
        final double valorEsperado = 1001.4;
        final Conta instance = new Conta();
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);
        final double valorObtido = instance.getSaldoTotal();
        /*É aceitável que a diferença entre esses dois valores seja 0.001, 
        assim o teste não ficará intermitente por causa de um pequeno erro de precisão */
        assertEquals(valorEsperado, valorObtido, 0.001);
    }
    
     /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números 
     * double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário
     * incluindo o que foi solicitado entre os minutos 04:12 e 04:42 do vídeo;
     * 
     * #Desafio do professor:
     * Verificar se a movimentação foi adicionada a lista de movimentações.
     * Método depositoDinheiro
     * Minha implementação
     */
    @Test
    public void testDepositoDinheiroAdicionandoMovimentacaoAListaMovimentacoes(){
        final Conta instance = new Conta();
        final int valorEsperado = instance.getMovimentacoes().size()+1;
        final double limite = 500.6;
        final double deposito = 500.8;
        instance.setEspecial(true);
        instance.setLimite(limite);        
        instance.depositoDinheiro(deposito);
        final int valorObtido = instance.getMovimentacoes().size();
        assertEquals(valorEsperado,valorObtido);
    }
    
     /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números 
     * double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário
     * incluindo o que foi solicitado entre os minutos 04:12 e 04:42 do vídeo;
     * 
     * #Desafio do professor:
     * Verificar se a movimentação foi confirmada.
     * Método depositoDinheiro
     * Minha implementação
     */
    @Test
    public void testedepositoDinheiroMovimentacaoIsTrue(){
        final Conta instance = new Conta();       
        final double limite = 500.6;
        final double deposito = 500.8;
        instance.setEspecial(true);
        instance.setLimite(limite);
        instance.depositoDinheiro(deposito);
        final int posicaoUltimaMovimentacao = instance.getMovimentacoes().size()-1;
        Movimentacao movimentacao = instance.getMovimentacoes().get(posicaoUltimaMovimentacao);
        assertTrue(movimentacao.isConfirmada());
    }
    
    
    /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números 
     * double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário
     * incluindo o que foi solicitado entre os minutos 04:12 e 04:42 do vídeo;
     * 
     * #Desafio do professor:
     * Verificar se o tipo da movimentação foi definido como crédito ('C').
     * Método depositoDinheiro
     * Minha implementação
     */
    @Test
    public void testedepositoDinheiroTipoMovimentacaoCredito(){
        final Conta instance = new Conta();
        final double limite = 500.6;
        final double deposito = 500.8;
        instance.setEspecial(true);
        instance.setLimite(limite);        
        instance.depositoDinheiro(deposito);
        final int posicaoUltimaMovimentacao = instance.getMovimentacoes().size()-1;
        Movimentacao movimentacao = instance.getMovimentacoes().get(posicaoUltimaMovimentacao);
        assertTrue(movimentacao.getTipo()== 'C');
    }
     
    /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números 
     * double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário
     * incluindo o que foi solicitado entre os minutos 04:12 e 04:42 do vídeo;
     * 
     * #Desafio do professor:
     * Verificar se valor foi atribuído a movimentação.
     * Método depositoDinheiro
     * Minha implementação
     */
    @Test
    public void testedepositoDinheiroValorAtribuidaAMovimentacao(){
        final Conta instance = new Conta();
        final double limite = 500.6;
        final double deposito = 500.8;
        instance.setEspecial(true);
        instance.setLimite(limite);        
        instance.depositoDinheiro(deposito);
        final int posicaoUltimaMovimentacao = instance.getMovimentacoes().size()-1;
        Movimentacao movimentacao = instance.getMovimentacoes().get(posicaoUltimaMovimentacao);
        System.out.println("Valor atribuído a movimentação: "+ movimentacao.getValor() + deposito);
        assertEquals(movimentacao.getValor(), deposito);
    }
        
    /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números 
     * double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário
     * incluindo o que foi solicitado entre os minutos 04:12 e 04:42 do vídeo;
     * 
     * #Desafio do professor:
     * Verificar se o valor passado é negativo.
     * Método depositoDinheiro
     * Minha implementação
     */
    @Test
    public void testedepositoDinheiroValorNegativo(){
        final Conta instance = new Conta();
        final double deposito = -1;
        assertThrows(IllegalArgumentException.class, () -> instance.depositoDinheiro(deposito));
    }
        
}
