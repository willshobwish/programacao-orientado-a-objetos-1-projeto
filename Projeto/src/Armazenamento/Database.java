/*
Andressa Yida Pinheiro de Souza
Willian Yoshio Murayama
Projeto semestral de programacao orientado a objetos
 */
package Armazenamento;

import Modelo.Departamento;

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
