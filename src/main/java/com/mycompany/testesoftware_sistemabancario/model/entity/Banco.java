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
 * Representa uma instituição bancária com os seguintes requisitos:
 * 
 * - Ao cadastrar um banco, deve ser criada ao menos uma agência;
 * - Não deve-se excluir um banco se este tiver agências cadastradas.
 */

/**
 *
 * @author Lidiane
 */


public class Banco extends Cadastro{
    
    private long id;
    private String nome;
    private String sigla;
    
    /**
     * Número único do banco.
     * 
     * (R01)
     * Deve ter exatamente 3 algarismos. Senão, uma exceção deve ser 
     * lançada informando o problema.
     * 
     * (R02)
     * O tipo é String para permitir restringir o total de caracteres, mas deve
     * ser informado um número válido (somente dígitos de 0 a 9). Senão for um
     * número válido, uma exceção deve ser lançada informando o problema. 
     * 
     * 
     * É um atributo obrigatório, não podendo ser nulo nem vazio. 
     * Se não for preenchido, uma exceção deve ser lançada informando o problema. 
     */
    
    private String numero;

    
    
    /**
     * @return the id
     */
    public long getId() {
        // TODO: Você precisa implementar este método
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        // TODO: Você precisa implementar este método
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
}
