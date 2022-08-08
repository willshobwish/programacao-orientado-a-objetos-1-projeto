/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Codigo.Departamento;

/**
 *
 * @author Willian
 */
public class Controle {

    private String Codigo;
    private String Nome;
    private double Salario;
    private String Categoria;
    private String Nivel;
    private Departamento Departamento = new Departamento();

    public void adicionarTecnicoControle(String codigo, String nome, double salario, String categoria, String nivel, String funcao) {
//        Tecnico T = new Tecnico(codigo, nome, salario, nivel, funcao);
        Departamento.adicionarTecnico(codigo, nome, salario, categoria, nivel, funcao);
    }

    protected void adicionarDocenteSubstituoControle(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, int cargaHoraria) {
        Departamento.adicionarDocenteSubstituto(codigo, nome, salario, categoria, nivel, titulacao, cargaHoraria);
    }

    protected void adicionarDocenteEfetivoControle(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, String area) {
        Departamento.adicionarDocenteEfetivo(codigo, nome, salario, categoria, nivel, titulacao, area);
    }

    public void Dados() {

    }
}
