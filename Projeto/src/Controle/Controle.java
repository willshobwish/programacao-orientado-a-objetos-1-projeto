/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Banco.Universidade;

/**
 *
 * @author Willian
 */
public class Controle {

    private static Universidade Universidade = new Universidade("Departamentos da universidade");

    public void adicionarDepartamento(String Codigo, String Nome) {
        Universidade.adicionarDepartamento(Codigo, Nome);
    }

    public String exibirTodosDepartamentos() {
        return Universidade.dadosTodosDepartamentos();
    }

    public int getQuantidadeDepartameto() {
        return Universidade.getQuantidadeDepartamento();
    }

    public String getDepartamentoNome(int Numero) {
        return Universidade.getNomeDepartamentoNumero(Numero);
    }

    public void cadastrarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, String area) {
        Universidade.adicionarDocenteEfetivo(codigo, nome, salario, categoria, nivel, departamento, titulacao, area);
    }

    public void cadastrarDocenteSubstituto(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, int cargaHoraria) {
        Universidade.adicionarDocenteSubstituto(codigo, nome, salario, categoria, nivel, departamento, titulacao, cargaHoraria);
    }

    public void cadastrarTecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao, String departamento) {
        Universidade.adicionarTecnico(codigo, nome, salario, categoria, nivel, funcao, departamento);
    }

    public String exibirTodosFuncionarios() {
        return Universidade.getFuncionarios();
    }

    public String exibirTodosTecnicos() {
        return Universidade.getTecnicos();
    }

    public String exibirTodosDocentesEfetivos() {
        return Universidade.getDocentesEfetivos();
    }

    public String exibirTodosDocentesSubstitutos() {
        return Universidade.getDocentesSubstitutos();
    }

    public String exibirDepartamentoEspecifico(String Nome) {
        return Universidade.getNomeDepartamentoNome(Nome);
    }
}
