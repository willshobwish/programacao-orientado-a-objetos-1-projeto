/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author Willian
 */
public class Tecnico extends Funcionario {

    protected String funcao;

    public Tecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao) {
        super(codigo, nome, salario, categoria, nivel);
        this.funcao = funcao;
    }

    public String getDados() {
        String Dados = """
                       Código: %s
                       Nome: %s
                       Salário: %s
                       Categoria: %s
                       Nível: %s
                       Função: %s

                       """.formatted(codigo, nome, Double.toString(salario), categoria, nivel, funcao);
        return Dados;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    double calcularSalario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
