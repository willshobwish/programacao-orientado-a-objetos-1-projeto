/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author Willian
 */
public class Efetivo extends Docente {

    protected String area;

    public Efetivo(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, String area) {
        super(codigo, nome, salario, categoria, nivel, titulacao);
        this.area = area;
    }

    @Override
    double calcularSalario() {
        return salario * 1.2;
    }
//Obtencao de dados

    public String getDados() {
        String Dados = """
                       Código: %s
                       Nome: %s
                       Salário: %s
                       Categoria: %s
                       Nível: %s
                       Titulação: %s
                       Área: %s
                       
                       """.formatted(codigo, nome, Double.toString(salario), categoria, nivel, titulacao, area);
        return Dados;
    }

//    Getter e Setter
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

}
