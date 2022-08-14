/*
Andressa Yida Pinheiro de Souza
Willian Yoshio Murayama
Projeto semestral de programacao orientado a objetos
 */
package Modelo;

public abstract class Funcionario {

    protected String codigo;
    protected String nome;
    protected double salario;
    protected String categoria;
    protected String nivel;

    abstract double calcularSalario();

    public Funcionario(String codigo, String nome, double salario, String categoria, String nivel) {
        this.codigo = codigo;
        this.nome = nome;
        this.salario = salario;
        this.categoria = categoria;
        this.nivel = nivel;
    }

//Getter
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getNivel() {
        return nivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

//Setter
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
