/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Codigo.Departamento;
import Persistencia.Database;

/**
 *
 * @author Willian
 */
public class Universidade {

    private String Nome;
    private Database DatabaseDepartamento = new Database();

    public Universidade(String Nome) {
        this.Nome = Nome;
    }

    public void adicionarDepartamento(String Codigo, String Nome) {
        Departamento NovoDepartamento = new Departamento(Codigo, Nome);
        DatabaseDepartamento.adicionarDepartamento(NovoDepartamento);
    }

    public String dadosTodosDepartamentos() {
        String Dados = "";
        Departamento Departamentos[] = DatabaseDepartamento.getDepartamentos();
        int Quantidade = DatabaseDepartamento.getIndex();
        for (int Index = 0; Index < Quantidade; Index++) {
            Dados = Dados + "Código do departamento: " + Departamentos[Index].getCodigo() + "\n" + "Nome do departamento: " + Departamentos[Index].getNome() + "\n" + "---";
        }
        return Dados;
    }

}
