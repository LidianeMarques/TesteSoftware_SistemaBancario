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
 * Cliente do banco tendo os seguintes requisitos:
 * 
 * - Ao cadastrar um cliente, deve ser criada ao menos uma conta;
 * - Não deve-se excluir um cliente se este tiver contas cadastradas.
 * 
 */

/**
 *
 * @author Lidiane
 */
public class Cliente implements Cadastro{
    
   private long id;

    /**
     * CPF que é uma das formas de permitir representar o cliente unicamente.
     *
     * <ul>
     * <li>Não pode ser vazio nem nulo, não pode ter todos os dígitos iguais,
     * não pode conter hífens e traços. (R01)</li>
     * <li>
     * Ao setar o CPF, deve-se utilizar o método {@link #isCpfValido(String)}
     * para verificar se o CPF é válido ou não. Se for inválido, o valor não
     * deve ser armazenado e deve-se lançar uma exceção com a mensagem "CPF
     * inválido".
     *
     * (R02)
     * </li>
     * <ul>
     */
    private String cpf;

    /**
     * Nome do cliente.
     * <ul>
     * <li>
     * É obrigatório, não podendo ser nulo, vazio nem uma String contendo apenas
     * espaços. Pode-se fazer nome = nome.trim() para remover quaisquer espaços
     * vazios no início e fim da String. Após isto, pode-se verificar se a
     * String é vazia. Se o nome for inválido, deve-se lançar uma exceção
     * informando o erro.
     *
     * (R03)
     * </li>
     * <li>
     *
     * Deve conter pelo menos um sobrenome. Para isto, depois da verificação
     * anterior, basta checar se há ao menos um espaço no nome, usando o método
     * contains() da classe String. Se não tiver um sobrenome, deve ser lançada
     * uma exceção informando isto.
     *
     * (R04)
     * </li>
     * </ul>
     */
    private String nome;

    @Override
    public long getId() {
        // TODO: Você precisa implementar este método
        return 0;
    }

    @Override
    public void setId(long id) {
        // TODO: Você precisa implementar este método
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        
        Objects.requireNonNull(cpf," O parametro de CPF não poder ser nulo!");
        
        if ( cpf.length() <= 0) {
            throw new IllegalArgumentException(
                    "CPF INVÁLIDO! O valor está em branco!");
        }
        else if (!cpf.matches("[0-9]+") ) {
            throw new IllegalArgumentException(
                     "CPF INVÁLIDO! Somente números!");
        }
        else if ( !isCpfValido(cpf) ) {
            throw new IllegalArgumentException(
                    "CPF INVÁLIDO! Coloque um CPF válido!");
        }

        this.cpf = cpf;
    }

    /**
     * Verifica se um CPF é válido ou não, utilizando o algoritmo denominado
     * Módulo 11, como descrito em
     * https://pt.wikipedia.org/wiki/Dígito_verificador#Módulo_11.
     *
     * Antes esta função era confusa e extensa. O processo de validação do CPF
     * envolve calcular o valor do primeiro e do segundo dígito, para então
     * comparar tais resultados com os dígitos informados pelo usuário. Tal
     * cálculo do dígito, apesar de ser um código de algumas linhas, é confuso
     * para quem nunca viu como é feito o processo de validação do CPF. Além
     * disso, tal cálculo precisa ser feito duas vezes, uma vez para cada
     * dígito. Desta forma, utilizamos um processo de refatoração para remover o
     * código que calcula um dígito para outro método chamado calculaDigito,
     * fora do método isCpfValido. Com isto, evitamos qualquer repetição de
     * código e tornamos o código do método isCpfValido menor e muito mais
     * legível.
     *
     * Ao criar o método calcularDigito, definimos sua visibilidade como
     * private, para indicar que ele não será acessível fora da classe. Isto
     * porque, o método é apenas parte do processo de validação do CPF. Ele
     * chamado fora deste processo não tem utilidade alguma. Desta forma,
     * colocando o método como private estamos aplicando o conceito de
     * encapsulamento, escondendo tal método dentro da classe. Assim, as outras
     * classes nem saberão que ele existe. Apenas o método isCpfValido é que
     * estará visível externamente para outras classes.
     *
     * @param cpf CPF a ser validado
     * @return true se o CPF for válido, false caso contrário.
     */
    public boolean isCpfValido(String cpf) {
        // Remove caracteres não numéricos do CPF
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        final String d1 = Util.calculaDigitoModulo11(cpf, 9);
        final String d2 = Util.calculaDigitoModulo11(cpf, 10);

        /* Converte os dígitos calculados de int para String e une (concatena) 
        os dois numa só String.*/
        final String digVerificadorCalculado = d1 + d2;

        // Copia os 2 últimos dígitos do CPF informado, pra comparar com os dígitos calculados
        final String digVerificadorExistente = cpf.substring(cpf.length() - 2);

        /* Compara os 2 últimos dígitos do CPF com os 2 calculados. 
           Se forem iguais, o CPF é válido. */
        return digVerificadorExistente.equals(digVerificadorCalculado);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
        Objects.requireNonNull(nome," O parametro de nome não poder ser nulo!");
        
        if(nome.trim().length() <= 0 || !nome.trim().contains(" ")){
            throw new IllegalArgumentException(
                    "NOME INVÁLIDO!");
        }
        
        this.nome = nome;
    }

    
}
