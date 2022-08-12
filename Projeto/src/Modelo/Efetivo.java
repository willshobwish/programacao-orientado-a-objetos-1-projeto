/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Willian
 */
public class Efetivo extends Docente {

    protected String area;

    public Efetivo(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, String area) {
        super(codigo, nome, salario, categoria, nivel, titulacao);
        this.area = area;
//        O docente efetivo possui um adicional de 5%
        this.salario = salario * 1.05;
    }

    @Override
    double calcularSalario() {
        double salarioTemp = 0;
        switch (nivel) {
            case "D1":
                salarioTemp = salario * 1.05;
                break;
            case "D2":
                salarioTemp = salario * 1.1;
                break;
            case "D3":
                salarioTemp = salario * 1.2;
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
                       Área: %s

                       """.formatted(codigo, nome, calcularSalario(), categoria, nivel, titulacao, area);
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
