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

    private Departamento Departamentos[];
    private int Maximo = 1000;
    private int ContadorDepartamento;

    public Database() {
        Departamentos = new Departamento[Maximo];
        ContadorDepartamento = 0;
    }

    public void adicionarDepartamento(Departamento NovoDepartamento) {
        if (ContadorDepartamento < Maximo) {
            Departamentos[ContadorDepartamento] = NovoDepartamento;
            ContadorDepartamento++;
        }
    }

    public Departamento[] getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(Departamento[] Departamentos) {
        this.Departamentos = Departamentos;
    }

    public int getMaximo() {
        return Maximo;
    }

    public void setMaximo(int Maximo) {
        this.Maximo = Maximo;
    }

    public int getContadorDepartamento() {
        return ContadorDepartamento;
    }

    public void setContadorDepartamento(int ContadorDepartamento) {
        this.ContadorDepartamento = ContadorDepartamento;
    }

}
