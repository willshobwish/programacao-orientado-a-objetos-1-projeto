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
public class Banco {

    private String Nome;
    private Database DatabaseDepartamento = new Database();

    public Banco(String Nome) {
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
            Dados = Dados + Departamentos[Index].getCodigo() + "\n" + Departamentos[Index].getNome() + "\n";
        }
        return Dados;
    }
}
