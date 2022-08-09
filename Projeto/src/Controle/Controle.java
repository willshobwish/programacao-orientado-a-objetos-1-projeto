/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Banco.Banco;

/**
 *
 * @author Willian
 */
public class Controle {

    private int cont = 1000;

    private Banco BancoDados = new Banco("Banco de Departamentos");

    public void adicionarDepartamento(String Codigo, String Nome) {
        BancoDados.adicionarDepartamento(Codigo, Nome);
    }

    public String exibirTodosDepartamentos() {
        return BancoDados.dadosTodosDepartamentos();
    }
}
