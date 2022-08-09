/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Codigo.Departamento;

/**
 *
 * @author Willian
 */
public class Database {

    private Departamento Departamentos[] = new Departamento[1000];
    private int Maximo = 1000;
    private int Index;

    public void adicionarDepartamento(Departamento NovoDepartamento) {
        if (Index < Maximo) {
            Departamentos[Index] = NovoDepartamento;
            Index++;
        }
    }

    public Departamento[] getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(Departamento[] Departamentos) {
        this.Departamentos = Departamentos;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int Index) {
        this.Index = Index;
    }

}
