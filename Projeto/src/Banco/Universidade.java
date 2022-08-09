/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Codigo.Departamento;
import Codigo.Efetivo;
import Codigo.Funcionario;
import Codigo.Substituto;
import Codigo.Tecnico;

/**
 *
 * @author Willian
 */
public class Universidade {

    private String Nome;
    private int Maximo;
    private int Contador;
    private Departamento Departamentos[];

    public Universidade(String Nome) {
        this.Nome = Nome;
        Maximo = 1000;
        Contador = 0;
        Departamentos = new Departamento[Maximo];
    }

//Adicao de objetos
    public void adicionarDepartamento(String Codigo, String Nome) {
        if (Contador < Maximo) {
            Departamentos[Contador] = new Departamento(Codigo, Nome);
            Contador++;
        }
    }

    public void adicionarTecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao, String departamento) {
        Tecnico Tecnico = new Tecnico(codigo, nome, salario, categoria, nivel, funcao);
        for (int i = 0; i < Contador; i++) {
            if (Departamentos[i].getNome().equals(departamento)) {
                Departamentos[i].adicionarFuncionario(Tecnico);
            }
        }
    }

    public void adicionarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, String area) {
        Efetivo Efetivo = new Efetivo(codigo, nome, salario, categoria, nivel, titulacao, area);
        for (int i = 0; i < Contador; i++) {
            if (Departamentos[i].getNome().equals(departamento)) {
                Departamentos[i].adicionarFuncionario(Efetivo);
            }
        }
    }

    public void adicionarDocenteSubstituto(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, int cargaHoraria) {
        Substituto Substituto = new Substituto(codigo, nome, salario, categoria, nivel, titulacao, cargaHoraria);
        for (int i = 0; i < Contador; i++) {
            if (Departamentos[i].getNome().equals(departamento)) {
                Departamentos[i].adicionarFuncionario(Substituto);
            }
        }
    }

//Exibicao de objetos
    public String dadosTodosDepartamentos() {
        String Dados = "";
        double Salario = 0;
        for (int Index = 0; Index < Contador; Index++) {
            Departamento DAtual = Departamentos[Index];
            Funcionario ListaFuncionario[] = DAtual.getListaFuncionario();
            for (int j = 0; j < DAtual.getContador(); j++) {
                Salario += ListaFuncionario[j].getSalario();
            }
            Dados = Dados + "Código do departamento: " + DAtual.getCodigo() + "\n" + "Nome do departamento: " + DAtual.getNome() + "\n" + "Salario total: R$" + Salario + "\n" + "Quantidade total de funcionários: " + DAtual.getContador() + "\n" + "---" + "\n";
        }
        return Dados;
    }

    public String getFuncionarios() {
        String Dados = "Lista de funcionários\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                Dados = Dados + "Código: " + ListaFuncionario[j].getCodigo() + "\n" + "Nome: " + ListaFuncionario[j].getNome() + "\n" + "---" + "\n";
            }
        }
        return Dados;
    }

    public String getTecnicos() {
        String Dados = "Lista de funcionários técnicos\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Tecnico")) {
                    Dados = Dados + "Código: " + ListaFuncionario[j].getCodigo() + "\n" + "Nome: " + ListaFuncionario[j].getNome() + "\n" + "---" + "\n";
                }
            }
        }
        return Dados;
    }

    public String getDocentesEfetivos() {
        String Dados = "Lista de docentes efetivos\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Docente efetivo")) {
                    Dados = Dados + "Código: " + ListaFuncionario[j].getCodigo() + "\n" + "Nome: " + ListaFuncionario[j].getNome() + "\n" + "---" + "\n";
                }
            }
        }
        return Dados;
    }

    public String getDocentesSubstitutos() {
        String Dados = "Lista de docentes substitutos\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Docente substituto")) {
                    Dados = Dados + "Código: " + ListaFuncionario[j].getCodigo() + "\n" + "Nome: " + ListaFuncionario[j].getNome() + "\n" + "---" + "\n";
                }
            }
        }
        return Dados;
    }

    public int getQuantidadeDepartamento() {
        return Contador;
    }

    public String getDepartamentoNome(int Numero) {
        return Departamentos[Numero].getNome();
    }
}
