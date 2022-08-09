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

    private int cont = 1000;

    private static Universidade BancoDados = new Universidade("Departamentos universidade");

    public void adicionarDepartamento(String Codigo, String Nome) {
        BancoDados.adicionarDepartamento(Codigo, Nome);
    }

    public String exibirTodosDepartamentos() {
        return BancoDados.dadosTodosDepartamentos();
    }

    public String exibirDepartamentos() {
//        return BancoDados.
    }

    public void cadastrarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, String area) {

    }

    public void cadastrarDocenteSubstituto() {

    }

    public void cadastrarTecnico() {

    }

}
