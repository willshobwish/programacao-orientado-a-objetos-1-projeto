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
    private int QuantidadeDepartamento;
    private Departamento ListaDepartamentos[];

    public Universidade(String Nome) {
        this.Nome = Nome;
        Maximo = 1000;
        QuantidadeDepartamento = 0;
        ListaDepartamentos = new Departamento[Maximo];
    }

//Adicao de objetos
    public void adicionarDepartamento(String Codigo, String Nome) {
        if (QuantidadeDepartamento < Maximo) {
            ListaDepartamentos[QuantidadeDepartamento] = new Departamento(Codigo, Nome);
            QuantidadeDepartamento++;
        }
    }

    public void adicionarTecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao, String departamento) {
        Tecnico Tecnico = new Tecnico(codigo, nome, salario, categoria, nivel, funcao);
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            if (ListaDepartamentos[i].getNome().equals(departamento)) {
                ListaDepartamentos[i].adicionarFuncionario(Tecnico);
            }
        }
    }

    public void adicionarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, String area) {
        Efetivo Efetivo = new Efetivo(codigo, nome, salario, categoria, nivel, titulacao, area);
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            if (ListaDepartamentos[i].getNome().equals(departamento)) {
                ListaDepartamentos[i].adicionarFuncionario(Efetivo);
            }
        }
    }

    public void adicionarDocenteSubstituto(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, int cargaHoraria) {
        Substituto Substituto = new Substituto(codigo, nome, salario, categoria, nivel, titulacao, cargaHoraria);
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            if (ListaDepartamentos[i].getNome().equals(departamento)) {
                ListaDepartamentos[i].adicionarFuncionario(Substituto);
            }
        }
    }

//    Calculo de salario total
    public double calculoSalario(Funcionario Funcionario) {
        double Salario = 0;
        switch (Funcionario.getCategoria()) {
            case "Tecnico":
//Casting de objetos para acessar os metodos especificos
                Tecnico T = (Tecnico) Funcionario;
                Salario += T.getSalario();
                break;
            case "Docente efetivo":
                Efetivo E = (Efetivo) Funcionario;
                Salario += E.getSalario();
                break;
            case "Docente substituto":
                Substituto S = (Substituto) Funcionario;
                Salario += S.getSalario();
                break;
        }
        return Salario;
    }

//Exibicao de objetos
    public String dadosTodosDepartamentos() {
        String Dados = "";
        double Salario = 0;
        for (int Index = 0; Index < QuantidadeDepartamento; Index++) {
            Salario = 0;
//            Pega um departamento para pegar os funcionarios
            Departamento DAtual = ListaDepartamentos[Index];
            Funcionario ListaFuncionario[] = DAtual.getListaFuncionario();
            for (int j = 0; j < DAtual.getQuantidadeFuncionario(); j++) {
                Salario += calculoSalario(ListaFuncionario[j]);
            }
            Dados = Dados + """
                            Código do departamento: %s
                            Nome do departamento: %s
                            Salario total dos funcionários: R$%.2f
                            Quantidade total de funcionários: %d

                            """.formatted(DAtual.getCodigo(), DAtual.getNome(), Salario, DAtual.getQuantidadeFuncionario());
        }
        return Dados;
    }

    public String getDadosFuncionarios(Funcionario Funcionario) {
        String Dados = "";
        switch (Funcionario.getCategoria()) {
            case "Tecnico":
                Tecnico T = (Tecnico) Funcionario;
                Dados = Dados + T.getDados();
                break;
            case "Docente efetivo":
                Efetivo E = (Efetivo) Funcionario;
                Dados = Dados + E.getDados();
                break;
            case "Docente substituto":
                Substituto S = (Substituto) Funcionario;
                Dados = Dados + S.getDados();
                break;
        }
        return Dados;
    }

    public String getFuncionarios() {
        String Dados = "";
//        Percorre o vetor de objetos de departamentos
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Dados = Dados + "Nome do departamento: " + ListaDepartamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                Dados += getDadosFuncionarios(ListaFuncionario[j]);
            }

        }
        return Dados;
    }

    public String getGeral() {
        String Dados = "";
        double Salario = 0;
//        Percorre o vetor de objetos de departamentos
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Salario = 0;
            Dados = Dados + "Nome do departamento: " + ListaDepartamentos[i].getNome() + "\nLista de funcionários:\n";
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                Dados += getDadosFuncionarios(ListaFuncionario[j]);
                Salario += calculoSalario(ListaFuncionario[j]);
            }
            Dados = Dados + """
                        Total de salário deste departamento: R$%.2f

                        """.formatted(Salario);
//            Dados += "Total de salário deste departamento: R$" + Double.toString(Salario) + "\n\n";
        }
        return Dados;
    }

    public String getTecnicos() {
        String Dados = "";
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Dados = Dados + "Nome do departamento: " + ListaDepartamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Tecnico")) {
                    Tecnico T = (Tecnico) ListaFuncionario[j];
                    Dados = Dados + T.getDados();
                }
            }
        }
        return Dados;
    }

    public String getDocentes() {
        String Dados = "";
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Dados = Dados + "Nome do departamento: " + ListaDepartamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
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
        String Dados = "";
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Dados = Dados + "Nome do departamento: " + ListaDepartamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Docente efetivo")) {
                    Efetivo E = (Efetivo) ListaFuncionario[j];
                    Dados = Dados + E.getDados();
                }
            }
        }
        return Dados;
    }

    public String getDocentesSubstitutos() {
        String Dados = "";
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Dados = Dados + "Nome do departamento: " + ListaDepartamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                if (ListaFuncionario[j].getCategoria().equals("Docente substituto")) {
                    Substituto S = (Substituto) ListaFuncionario[j];
                    Dados = Dados + S.getDados();
                }
            }
        }
        return Dados;
    }

    public int getQuantidadeDepartamento() {
        return QuantidadeDepartamento;
    }

    public String getNomeDepartamentoNumero(int Numero) {
        return ListaDepartamentos[Numero].getNome();
    }

    public String getDepartamentoCodigoNumero(int Numero) {
        return ListaDepartamentos[Numero].getCodigo();
    }

    public String getNomeDepartamentoCodigo(String Codigo) {
        String Nome = "";
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            if (ListaDepartamentos[i].getCodigo().equals(Codigo)) {
                Nome = ListaDepartamentos[i].getNome();
            }
        }
        return Nome;
    }

    public String getExibirDepartamentoEspecifico(String Nome) {
        Departamento ResultadoDepartamento = null;
        double Salario = 0;
        String Dados = "";
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            if (ListaDepartamentos[i].getNome().equals(Nome)) {
                ResultadoDepartamento = ListaDepartamentos[i];
            }
        }
        Dados = Dados + """
                            Código do departamento: %s
                            Nome do departamento: %s
                            Lista de funcionários:
                            """.formatted(ResultadoDepartamento.getCodigo(), ResultadoDepartamento.getNome());
        int QuantidadeFuncionario = ResultadoDepartamento.getQuantidadeFuncionario();
        Funcionario ResultadoFuncionarios[] = ResultadoDepartamento.getListaFuncionario();
        for (int i = 0; i < QuantidadeFuncionario; i++) {
            Salario += calculoSalario(ResultadoFuncionarios[i]);
            Dados = Dados + """
                            Nome: %s
                            """.formatted(ResultadoFuncionarios[i].getNome());
        }
        Dados = Dados + """
                        Salário total: R$%.2f
                        ---
                        """.formatted(Salario);
        return Dados;
    }

    public Departamento buscarFaixaDepartamento(double Minimo, double Maximo) {
        double SalarioTotal;
        Departamento Departamento = null;
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            SalarioTotal = 0;
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                SalarioTotal += calculoSalario(ListaFuncionario[j]);
            }
            if (SalarioTotal > Minimo && SalarioTotal < Maximo) {
                Departamento = ListaDepartamentos[i];
            } else {
                Departamento = null;
            }
        }
        return Departamento;
    }

    public String buscarFaixaDepartamentoString(double Minimo, double Maximo) {
        String Dados = "";
        Departamento D = buscarFaixaDepartamento(Minimo, Maximo);
        if (D != null) {
            Funcionario ListaFuncionario[] = D.getListaFuncionario();
            for (int i = 0; i < D.getQuantidadeFuncionario(); i++) {
                Dados = Dados + getDadosFuncionarios(ListaFuncionario[i]);
            }
        } else {
            Dados = "Departamento com faixa especificada não encontrado";
        }
        return Dados;
    }

    public String buscarFuncionarioString(double Minimo, double Maximo) {
        String Dados = "";
        for (int i = 0; i < QuantidadeDepartamento; i++) {
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                if (calculoSalario(ListaFuncionario[j]) > Minimo && calculoSalario(ListaFuncionario[j]) < Maximo) {
                    Dados = Dados + getDadosFuncionarios(ListaFuncionario[j]);
                }
            }
        }
        if (Dados.equals("")) {
            Dados = "Nenhum funcionário foi encontrado com essa faixa de salário especificado";
        }
        return Dados;
    }
}
