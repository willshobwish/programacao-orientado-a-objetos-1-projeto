/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Willian
 */
public class Substituto extends Docente {

    protected int cargaHoraria;

    public Substituto(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, int cargaHoraria) {
        super(codigo, nome, salario, categoria, nivel, titulacao);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    double calcularSalario() {
        double salarioTemp = 0;
        switch (nivel) {
            case "S1":
                salarioTemp = salario * 1.05;
                break;
            case "S2":
                salarioTemp = salario * 1.1;
                break;
        }
        return salarioTemp;

    }
//Obtencao de dados

    public String getDados() {
        String Dados = """
                       Código: %s
                       Nome: %s
                       Salário: R$%.2f
                       Categoria: %s
                       Nível: %s
                       Titulação: %s
                       Carga Horária: %dh

                       """.formatted(codigo, nome, calcularSalario(), categoria, nivel, titulacao, cargaHoraria);
        return Dados;
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
        return calcularSalario();
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
