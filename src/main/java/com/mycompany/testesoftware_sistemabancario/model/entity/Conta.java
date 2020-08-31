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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa uma conta bancária de um determinado {@link Cliente}, tendo os
 * seguintes requisitos:
 *
 * - Uma conta não pode ser excluída se existirem movimentações.
 */
/**
 *
 * @author Lidiane
 */
public class Conta implements Cadastro {

    private long id;
    private String numero;
    /**
     * Número que identifica unicamente uma conta em uma determinada agência,
     * devendo estar no formato 99999-9. Se o número não estiver no formato
     * indicado, o valor não pode ser armazenado e uma exceção deve ser lançada
     * (R01). O número da agência tem um dígito verificador como no CPF, mas
     * isto é outro requisito não definido aqui.
     */

    private boolean poupanca;
    /**
     * Contas devem ser instanciadas como "Conta Corrente" e não como
     * "Poupança". (R02) O valor padrão para atributos boolean é false, assim
     * não precisamos escrever código adicional para definir "poupanca" como
     * false. Mas é preciso escrever o teste para verificar tal situação. Com
     * isto, buscamos detectar se uma alteração no código fizer com que este
     * requisito deixe de ser atendido.
     */

    private boolean especial;
    /**
     * Indica se a conta é especial ou não. Caso seja, ela pode ter
     * {@link #limite}.
     */

    private double saldo;
    /**
     * Valor que o cliente possui na conta, sem incluir o {@link #limite}.
     */

    private double limite;
    /**
     * Limite da conta: valor que o cliente pode utilizar além do {@link #saldo}
     * disponível. Somente contas especiais podem ter limite, ou seja, o limite
     * de contas "não especiais" não pode ser maior que zero (R03).
     */
    //Inicializando vazia a lista de movimanetações.
    /* Código prof vídeo-aula#1. */
    private List<Movimentacao> movimentacoes = new ArrayList<>();

    /**
     * Histórico de movimentações da conta. Deve ser inicializado com uma lista
     * vazia. Sem isto, ao tentar utilizar a lista, dará o erro
     * NullPointerException. Um teste deve verificar se, após instanciar uma
     * conta usando qualquer um dos construtores, a lista de movimentações não é
     * nula, chamando o método {@link #getMovimentacoes()}. (R04)
     */
    public Conta() {
        // TODO: Você precisa implementar este método
    }

    public Conta(Agencia agencia, boolean especial, final double limite) {
        // TODO: Você precisa implementar este método
    }

//-------------------------------------------------------------------------------
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
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Implementar requisitos do vídeo #1 do Sistema Bancário; 
     * Implementar os requisitos R01 a R04 para a classe Conta;
     * (R01).
     */
    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        /*vídeo-aula#1. Minha implementação*/
        //Aqui verifica se a variável numero é nula ou não
        Objects.requireNonNull(numero," O parametro de número não poder ser nulo!");
        
        /* Código prof vídeo-aula#1. */
        if (!numero.matches("\\d{5}-\\d")) {
            throw new IllegalArgumentException(
                    "Número inválido!. Deve estar no formato: 00000-0");
        }

        this.numero = numero;
    }

    /**
     * @return the poupanca
     */
    public boolean isPoupanca() {
        return poupanca;
    }

    /**
     * @param poupanca the poupanca to set
     */
    public void setPoupanca(boolean poupanca) {
        this.poupanca = poupanca;
    }

    /**
     * @return the especial
     */
    public boolean isEspecial() {
        return especial;
    }

    /**
     * @param especial the especial to set
     */
    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * Implementar requisitos do vídeo #1 do Sistema Bancário; 
     * Implementar os requisitos R01 a R04 para a classe Conta; 
     * (R03);
     * Somente contas especiais podem ter limite, ou seja, o limite
     * de contas "não especiais" não pode ser maior que zero.
     */
    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        /* Código prof vídeo-aula#1. */
        if(!especial && limite > 0){
            throw new IllegalStateException("Somente contas especiais podem ter limite");
        }
        this.limite = limite;
    }

    /**
     * @return Retorna a lista de movimentações.
     */
    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    /**
     * @param movimentacoes the movimentacoes to set
     */
    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
//-------------------------------------------------------------------------------

    /**
     * Adiciona uma nova movimentação à lista de {@link #movimentacoes}. (R05)
     * Se a movimentação estiver confirmada, seu valor deve ser: - somado ao
     * saldo da conta caso o tipo da movimentação seja 'C'; - subtraída do saldo
     * da conta caso o tipo da movimentação seja 'D'.
     *
     * @param movimentacao {@link Movimentacao} a ser adicionada
     * Vídeo-aula: Entendendo e aplicando Cobertura de Código em Java: 
     * Analisando o percentual de código coberto por testes.
     * Código prof vídeo-aula.
     */
    public void addMovimentacao(Movimentacao movimentacao) {
        if (movimentacao.isConfirmada()) {
            if (movimentacao.getTipo() == 'C') {
                saldo += movimentacao.getValor();
            }
             /*Minha implementação*/
            if (movimentacao.getTipo() == 'D') {
                saldo -= movimentacao.getValor();
            }
        }
    }

    /**
     * (R06) Valor total disponível na conta, representando o {@link #saldo}
     * mais o {@link #limite}.
     *
     * @return
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números double no JUnit 5.
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário,
     */
    public double getSaldoTotal() {
        /* Código prof vídeo-aula#2. */
        return saldo + limite;
    }

    /**
     * Registra uma nova movimentação para retirar um determinado valor da
     * conta, caso o valor seja menor ou igual ao saldo total. Após realizar um
     * saque, o saldo deve ser atualizado.
     *
     *
     * Se for tentando realizar dois saques ao mesmo tempo com valor igual ao
     * saldo total, somente o primeiro saque deve ser permitido. Isto evita que
     * um cliente que possua dois cartões da mesma conta tente retirar mais
     * dinheiro do que há disponível na conta. Ele poderia tentar fazer isso
     * solicitando a ajuda de outra pessoa. Assim, as duas pessoas poderiam
     * tentar ir em caixas diferentes ao mesmo tempo para tentar realizar um
     * saque em duplicidade.
     *
     * @param valor valor a ser sacado (deve ser um valor positivo)
     */
    public void saque(final double valor) {
        /*Minha implementação, verifica se a conta tem dinheiro*/
        if ((getSaldoTotal()- valor) < 0) {
            throw new IllegalArgumentException(
                    "Não tem dinheiro na conta! "
            );
        }
        /* Código prof vídeo-aula#2. */
        Movimentacao movimentacao = new Movimentacao(this);
        movimentacao.setConfirmada(true);
        movimentacao.setTipo('D');
        movimentacao.setValor(valor);
        if(valor <= saldo){
            saldo -= valor;
        }else{
            limite -= ( valor - saldo);
            saldo = 0;
        }
        
        
        movimentacoes.add(movimentacao);
    }

    /**
     * Adiciona uma nova movimentação de depósito em envelope (que deve ser
     * confirmada posteriormente por um funcionário do banco).
     *
     * @param valor valor a ser depositado (deve ser um valor positivo)
     */
    public void depositoEnvelope(final double valor) {
        // TODO: Você precisa implementar este método
    }

    /**
     * Adiciona uma nova movimentação de depósito em cheque (que deve ser
     * confirmada posteriormente por um funcionário do banco).
     *
     * @param valor valor a ser depositado (deve ser um valor positivo)
     */
    public void depositoCheque(final double valor) {
        // TODO: Você precisa implementar este método
    }
    
    /**
     * Vídeo-aula #2: Evitando problemas de testes intermitentes com números double no JUnit 5;
     * Realize a implementação feita na segunda parte do vídeo do sistema bancário;
     * 
     * Adiciona uma nova movimentação de deposito em dinheiro tanto realizada por
     * funcionário quanto em um caixa eletrônico que deve ser confirmada automaticamente;
     * Considera-se que todos os caixas eletrônicos do banco têm capacidade de contas
     * cédulas.
     * @param valor valor a ser depositado (deve ser um valor positivo).
     * 
     */
    public void depositoDinheiro(final double valor) {
        /*Minha implementação, verifica se o valor do deposito é negativo ou igual a zero*/
        if (valor <= 0) {
            throw new IllegalArgumentException(
                    "Os valores do deposito não pode ser negativo ou igual a zero! "
            );
        }

        /* Código prof vídeo-aula#2. */
        Movimentacao movimentacao = new Movimentacao(this);
        movimentacao.setConfirmada(true);
        movimentacao.setTipo('C');
        movimentacao.setValor(valor);
        saldo += valor;
        movimentacoes.add(movimentacao);

        
        
    }
    
}
