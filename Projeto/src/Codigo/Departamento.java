/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author Willian
 */
public class Departamento {

    private String codigo;
    private String nome;
    private Funcionario ListaFuncionario[] = new Funcionario[1000];
    private int contador = 0;
    private int maximo = 1000;

    public Departamento(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public void adicionarFuncionario(Funcionario funcionarioObjeto) {
        if (contador < maximo) {
            ListaFuncionario[contador] = funcionarioObjeto;
            contador++;
        }
    }

    public void adicionarTecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao) {
        Tecnico Tecnico = new Tecnico(codigo, nome, salario, categoria, nivel, funcao);
        adicionarFuncionario(Tecnico);
    }

    public void adicionarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, String area) {
        Efetivo DocenteEfetivo = new Efetivo(codigo, nome, salario, categoria, nivel, titulacao, area);
        adicionarFuncionario(DocenteEfetivo);

    }

    public void adicionarDocenteSubstituto(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, int cargaHoraria) {
        Substituto DocenteSubstituto = new Substituto(codigo, nome, salario, categoria, nivel, titulacao, cargaHoraria);
        adicionarFuncionario(DocenteSubstituto);
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidadeFuncionario() {
        return contador;
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

    public Funcionario[] getListaFuncionario() {
        return ListaFuncionario;
    }

    public void setListaFuncionario(Funcionario[] ListaFuncionario) {
        this.ListaFuncionario = ListaFuncionario;
    }

}
