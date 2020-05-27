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
public class Movimentacao extends Cadastro {

    private long id;
    private String descricao;

    /**
     * Conta bancária a qual a movimentação está vinculada.
     */
    private Conta conta;

    /**
     * (R01) 
     * Tipo da movimentação deve ser 'C' para crédito (entrada de
     * dinheiro) ou 'D' para débito (saída de dinheiro).
     */
    private char tipo;

    /**
     * Valor monetário da movimentação.
     *
     * (R02)
     * O valor não deve ser negativo, uma vez que existe o atributo
     * {@link #tipo}.
     *
     * (R03) 
     * Se o tipo for débito, o valor da movimentação não pode ser superior
     * ao saldo total da {@link Conta}.
     */
    private double valor;

    /**
     * Indica se a movimentação foi confirmada e deve ser registrada no saldo da
     * conta, quando for adicionada à lista de movimentações usando
     * {@link Conta#addMovimentacao(Movimentacao)}.
     *
     * (R04)
     * Movimentacoes devem ser instanciadas como "confirmadas" por
     * padrão.
     *
     *
     * Somente operações como depósito em envelope ou em cheque devem ser
     * registradas inicialmente como não confirmadas. Após uma operação ser
     * confirmada, deve-se atualizar o saldo da conta.
     *
     * @see Conta#depositoEnvelope(double)
     * @see Conta#depositoCheque(double)
     */
    private boolean confirmada;

    
    /**
     * Instancia uma movimentação para uma determinada {@link Conta} bancária. (R05)
     * @param conta a {@link Conta} para vincular a movimentação.
     */
    public Movimentacao(Conta conta){
        // TODO: Você precisa implementar este método
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }

    /**
     * @return the tipo
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the confirmada
     */
    public boolean isConfirmada() {
        return confirmada;
    }

    /**
     * @param confirmada the confirmada to set
     */
    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

}
