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

/**
 *
 * Representa uma movimentação em uma {@link Conta} bancária, que pode indicar
 * entrada ou saída.
 *
 * NOTA: Mesmo sendo possível obter o saldo somando-se todas as movimentações, à
 * medida que os dados no sistema aumentarem ao longo do tempo, calcular o saldo
 * pode se tornar uma operação extremamente lenta. Isto normalmente ocorrer
 * quando o histórico de movimentações se torna longo (principalmente depois de
 * alguns anos).
 *
 */
/**
 *
 * @author Lidiane
 */
public class Movimentacao implements Cadastro {

    private long id;
    private String descricao;

    /**
     * Conta bancária a qual a movimentação está vinculada.
     */
    private Conta conta;

    /**
     * Tipo da movimentação deve ser 'C' para crédito (entrada de dinheiro) ou
     * 'D' para débito (saída de dinheiro) (R01).
     */
    private char tipo;

    /**
     * Valor monetário da movimentação. O valor não deve ser negativo, uma vez
     * que existe o atributo {@link #tipo} (R02). Se o tipo for débito, o valor
     * da movimentação não pode ser superior ao saldo total da {@link Conta}
     * (R03).
     */
    private double valor;

    /**
     * Indica se a movimentação foi confirmada, neste caso, devendo ser
     * registrada no saldo da conta, quando for adicionada à lista de
     * movimentações usando {@link Conta#addMovimentacao(Movimentacao)}.
     *
     * <ul>
     * <li>Movimentacoes devem ser instanciadas como "confirmadas" por padrão
     * (R04).</li>
     * <li>
     * Somente operações como depósito em cheque devem ser registradas
     * inicialmente como não confirmadas. Após uma operação ser confirmada,
     * deve-se atualizar o saldo da conta.
     * <li>
     * </ul>
     *
     * @see Conta#depositoDinheiro(double)
     * @see Conta#depositoCheque(double)
     */
    private boolean confirmada;

    /**
     * Instancia uma movimentação para uma determinada {@link Conta} bancária,
     * onde a conta passada deve ser armazenada no atributo {@link #conta}
     * (R05).
     *
     * @param conta a {@link Conta} para vincular a movimentação.
     */
    public Movimentacao(Conta conta) {
        //R05
        this.conta = conta;

        //R04_Movimentacoes devem ser instanciadas como "confirmadas" por padrão
        this.confirmada = true;

    }

    /**R05
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**R05
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    
}
