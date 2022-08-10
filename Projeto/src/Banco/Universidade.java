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

//    Calculo de salario total
    public double calculoSalario(Funcionario Funcionario) {
        double SalarioTotal = 0;
        switch (Funcionario.getCategoria()) {
            case "Tecnico":
//Casting de objetos para acessar os metodos especificos
                Tecnico T = (Tecnico) Funcionario;
                SalarioTotal += T.getSalario();
                break;
            case "Docente efetivo":
                Efetivo E = (Efetivo) Funcionario;
                SalarioTotal += E.getSalario();
                break;
            case "Docente substituto":
                Substituto S = (Substituto) Funcionario;
                SalarioTotal += S.getSalario();
                break;
        }
        return SalarioTotal;
    }

//Exibicao de objetos
    public String dadosTodosDepartamentos() {
        String Dados = "";
        double Salario = 0;
        for (int Index = 0; Index < Contador; Index++) {
            Salario = 0;
//            Pega um departamento para pegar os funcionarios
            Departamento DAtual = Departamentos[Index];
            Funcionario ListaFuncionario[] = DAtual.getListaFuncionario();
            for (int j = 0; j < DAtual.getContador(); j++) {
                Salario += calculoSalario(ListaFuncionario[j]);
            }
            Dados = Dados + """
                            Código do departamento: %s
                            Nome do departamento: %s
                            Salario total: R$%.2f
                            Quantidade total de funcionários: %d

                            """.formatted(DAtual.getCodigo(), DAtual.getNome(), Salario, DAtual.getContador());
        }
        return Dados;
    }

    public String getFuncionarios() {
        String Dados = "Lista de funcionários:\n";
//        Percorre o vetor de objetos de departamentos
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Nome do departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                switch (ListaFuncionario[j].getCategoria()) {
                    case "Tecnico":
                        Tecnico T = (Tecnico) ListaFuncionario[j];
                        Dados = Dados + T.getDados();
                        break;
                    case "Docente efetivo":
                        Efetivo E = (Efetivo) ListaFuncionario[j];
                        Dados = Dados + E.getDados();
                        break;
                    case "Docente substituto":
                        Substituto S = (Substituto) ListaFuncionario[j];
                        Dados = Dados + S.getDados();
                        break;
                }
            }
        }
        return Dados;
    }

    public String getTecnicos() {
        String Dados = "Lista de funcionários técnicos:\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Nome do departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Tecnico")) {
                    Tecnico T = (Tecnico) ListaFuncionario[j];
                    Dados = Dados + T.getDados();
                }
            }
        }
        return Dados;
    }

    public String getDocentes() {
        String Dados = "Lista de docentes efetivos:\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Nome do departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                switch (ListaFuncionario[j].getCategoria()) {
                    case "Docente efetivo":
                        Efetivo E = (Efetivo) ListaFuncionario[j];
                        Dados = Dados + E.getDados();
                        break;
                    case "Docente substituto":
                        Substituto S = (Substituto) ListaFuncionario[j];
                        Dados = Dados + S.getDados();
                        break;
                }
            }
        }
        return Dados;
    }

    public String getDocentesEfetivos() {
        String Dados = "Lista de docentes efetivos\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Nome do departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Docente efetivo")) {
                    Efetivo E = (Efetivo) ListaFuncionario[j];
                    Dados = Dados + E.getDados();
                }
            }
        }
        return Dados;
    }

    public String getDocentesSubstitutos() {
        String Dados = "Lista de docentes substitutos\n";
        for (int i = 0; i < Contador; i++) {
            Dados = Dados + "Nome do departamento: " + Departamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = Departamentos[i].getListaFuncionario();
            for (int j = 0; j < Departamentos[i].getContador(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Docente substituto")) {
                    Substituto S = (Substituto) ListaFuncionario[j];
                    Dados = Dados + S.getDados();
                }
            }
        }
        return Dados;
    }

    public int getQuantidadeDepartamento() {
        return Contador;
    }

    public String getNomeDepartamentoNumero(int Numero) {
        return Departamentos[Numero].getNome();
    }

    public String getDepartamentoCodigoNumero(int Numero) {
        return Departamentos[Numero].getCodigo();
    }

    public String getNomeDepartamentoCodigo(String Codigo) {
        String Nome = "";
        for (int i = 0; i < Contador; i++) {
            if (Departamentos[i].getCodigo().equals(Codigo)) {
                Nome = Departamentos[i].getNome();
            }
        }
        return Nome;
    }

    public String getExibirDepartamentoEspecifico(String Nome) {
        Departamento ResultadoDepartamento = null;
        double Salario = 0;
        String Dados = "";
        for (int i = 0; i < Contador; i++) {
            if (Departamentos[i].getNome().equals(Nome)) {
                ResultadoDepartamento = Departamentos[i];
            }
        }
        Dados = Dados + """
                            Código do departamento: %s
                            Nome do departamento: %s
                            Lista de funcionários:
                            """.formatted(ResultadoDepartamento.getCodigo(), ResultadoDepartamento.getNome());
        int QuantidadeFuncionario = ResultadoDepartamento.getContador();
        Funcionario ResultadoFuncionarios[] = ResultadoDepartamento.getListaFuncionario();
        for (int i = 0; i < QuantidadeFuncionario; i++) {
            Salario += calculoSalario(ResultadoFuncionarios[i]);
            Dados = Dados + """
                            Nome: %s
                            """.formatted(ResultadoFuncionarios[i].getNome());
        }
        Dados = Dados + "Salário total: R$ " + Salario;
        return Dados;
    }
}
