/*
Andressa Yida Pinheiro de Souza
Willian Yoshio Murayama
Projeto semestral de programacao orientado a objetos
 */
package Controle;

import Manipulacao.Universidade;

public class Controle {
//Criacao do objeto estatico universidade

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

    public String getDepartamentoNomeNumero(int Numero) {
        return Universidade.getNomeDepartamentoNumero(Numero);
    }

    public String getDepartamentoCodigoNumero(int Numero) {
        return Universidade.getDepartamentoCodigoNumero(Numero);
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

    public String exibirGeral() {
        return Universidade.getGeral();
    }

    public String exibirTodosFuncionarios() {
        return Universidade.getTodosFuncionariosDepartamentos();
    }

    public String exibirTodosTecnicos() {
        return Universidade.getTecnicos();
    }

    public String exibirTodosDocentes() {
        return Universidade.getDocentes();
    }

    public String exibirTodosDocentesEfetivos() {
        return Universidade.getDocentesEfetivos();
    }

    public String exibirTodosDocentesSubstitutos() {
        return Universidade.getDocentesSubstitutos();
    }

    public String exibirDepartamentoEspecifico(String Nome) {
        return Universidade.getExibirDepartamentoEspecifico(Nome);
    }

    public String getNomeDepartamentoCodigo(String Codigo) {
        return Universidade.getNomeDepartamentoCodigo(Codigo);
    }

    public String buscarFaixaDepartamento(double Minimo, double Maximo) {
        return Universidade.buscarFaixaDepartamentoString(Minimo, Maximo);
    }

    public String buscarFuncionarioString(double Minimo, double Maximo) {
        return Universidade.buscarFuncionarioString(Minimo, Maximo);
    }

    public String buscarFuncionarioCodigoString(String Codigo) {
        return Universidade.getFuncionarioBuscaCodigo(Codigo);
    }

    public String buscarFuncionarioNomeString(String Nome) {
        return Universidade.getFuncionarioBuscaNome(Nome);
    }

    public boolean codigoRepetidoDepartamento(String Nome) {
        return Universidade.codigoRepetidoDepartamento(Nome);
    }

    public boolean codigoRepetidoFuncionario(String Codigo) {
        return Universidade.codigoRepetidoFuncionario(Codigo);
    }
}
