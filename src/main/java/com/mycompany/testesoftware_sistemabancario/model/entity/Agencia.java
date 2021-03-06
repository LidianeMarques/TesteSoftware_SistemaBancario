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

import java.util.Objects;

/**
 *
 * @author Lidiane
 */
public class Agencia implements Cadastro {

    private long id;

    /**
     * (R01) Banco ao qual a agência pertence. O banco deve ser fornecido como
     * um parâmetro no construtor, pois não pode haver agência sem banco. Um
     * teste deve verificar se, após usar tal construtor para instanciar a
     * agência, se o atributo banco foi setado (ou seja, se não é nulo).
     *
     */
    private Banco banco;

    /**
     * Número único da agência bancária para um banco.
     *
     * (R02) O valor é obrigatório, não podendo ser nulo nem vazio.
     *
     * (R03) Deve ter exatamente 4 algarismos, seguido de um hífen e mais um
     * dígito verificador. (o hífen é pra deixar clara a existência de tal
     * dígito). Exemplos de números de agência válidos inclui: 0638-6, 1886-4,
     * 1867-8.
     *
     * (R04) Deve ser validado usando o algoritmo do Módulo 11, que está
     * implementado no método {@link Util#calculaDigitoModulo11(String)}. Você
     * deve chamar o método como String digitoCalculado =
     * Util.calculaDigitoModulo11(numero) e então verificar se o dígito
     * informado em numero é igual ao dígito calculado pelo método e armazenado
     * na variável digitoCalculado no exemplo acima. Uma forma simples de fazer
     * isso é verificar se a String numero termina com o digitoCalculado, usando
     * o método endsWith da classe String. Se o numero não terminar com o
     * digitoCalculado, ele é inválido e uma exceção deve ser lançada para
     * informar isso.
     *
     */
    private String numero;

    Agencia(Banco banco) {
        this.banco = banco;
    }

    @Override
    public long getId() {
        // TODO: Você precisa implementar este método
        return 0;
    }

    @Override
    public void setId(long id) {
        // TODO: Você precisa implementar este método
    }

    public String getNumero() {
        return numero;
    }

    /**
     * Altera o número da agência, verificando se o dígito está correto
     * utilizando o algoritmo
     * <a href="https://pt.wikipedia.org/wiki/Dígito_verificador#Módulo_11">modulo
     * 11</a>.
     *
     * @param numero novo número da agência
     */
    public void setNumero(String numero) {
        Objects.requireNonNull(numero, " O parametro de número não poder ser nulo!");

        if (numero.replace(" ", "").length() <= 0) {
            throw new IllegalArgumentException(
                    "Número Vazio!");
        }
        if (!numero.matches("\\d\\d\\d\\d-\\d")) {
            throw new IllegalArgumentException("Formato Invalido do número deve ser 0000-0");
        }

        String digitoCalculado = Util.calculaDigitoModulo11(numero);

        if (!numero.endsWith(digitoCalculado)) {
            throw new IllegalArgumentException("O número passado é invalido, digito verificador não confere");
        }
        this.numero = numero;
    }

    /**
     * @return the banco
     */
    public Banco getBanco() {
        return banco;
    }

}
