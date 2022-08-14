/*
Andressa Yida Pinheiro de Souza
Willian Yoshio Murayama
Projeto semestral de programacao orientado a objetos
 */
package Modelo;

public abstract class Docente extends Funcionario {

    protected String titulacao;

    abstract double calcularSalario();

    public Docente(String codigo, String nome, double salario, String categoria, String nivel, String titulacao) {
        super(codigo, nome, salario, categoria, nivel);
        this.titulacao = titulacao;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getSalario() {
        return salario;
    }

    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
