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
    private int Maximo;
    private int Contador;

    public Database() {
        Departamentos = new Departamento[Maximo];
        Contador = 0;
    }

    public void adicionarDepartamento(Departamento NovoDepartamento) {
        if (Contador < Maximo) {
            Departamentos[Contador] = NovoDepartamento;
            Contador++;
        }
    }

    public Departamento[] getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(Departamento[] Departamentos) {
        this.Departamentos = Departamentos;
    }

    public int getIndex() {
        return Contador;
    }

    public void setIndex(int Index) {
        this.Contador = Index;
    }

}
