/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manipulacao;

import Armazenamento.Database;
import Modelo.Departamento;
import Modelo.Efetivo;
import Modelo.Funcionario;
import Modelo.Substituto;
import Modelo.Tecnico;

/**
 *
 * @author Willian
 */
public class Universidade {

    private String Nome;
    private Database Database;

    public Universidade(String Nome) {
        this.Nome = Nome;
        Database = new Database();
    }

//Adicao de departamentos no database
    public void adicionarDepartamento(String Codigo, String Nome) {
        if (Database.getContadorDepartamento() < Database.getMaximo()) {
            Database.adicionarDepartamento(new Departamento(Codigo, Nome));
        }
    }

//    Adicao de funcionarios dependendo da categoria e do departamento
//    Um dos parametros necessario eh em que departamento sera inserido o funcionario
    public void adicionarTecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao, String departamento) {
        Tecnico Tecnico = new Tecnico(codigo, nome, salario, categoria, nivel, funcao);
//        Recuperacao da lista de departamentos existentes e criados
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
//        Busca de departamento selecionado na interface para adicao do funcionario
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            if (ListaDepartamentos[i].getNome().equals(departamento)) {
                ListaDepartamentos[i].adicionarFuncionario(Tecnico);
            }
        }
    }

    public void adicionarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, String area) {
        Efetivo Efetivo = new Efetivo(codigo, nome, salario, categoria, nivel, titulacao, area);
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            if (ListaDepartamentos[i].getNome().equals(departamento)) {
                ListaDepartamentos[i].adicionarFuncionario(Efetivo);
            }
        }
    }

    public void adicionarDocenteSubstituto(String codigo, String nome, double salario, String categoria, String nivel, String departamento, String titulacao, int cargaHoraria) {
        Substituto Substituto = new Substituto(codigo, nome, salario, categoria, nivel, titulacao, cargaHoraria);
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
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

//    Exibicao de todos os departamentos
    public String dadosTodosDepartamentos() {
        String Dados = "";
        double Salario;
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int Index = 0; Index < Database.getContadorDepartamento(); Index++) {
            Salario = 0;
//            Percorre o vetor de departamentos um de cada vez
            Departamento DAtual = ListaDepartamentos[Index];
            Funcionario ListaFuncionario[] = DAtual.getListaFuncionario();
//            Percorre o vetor de funcionarios de um departamento um de cada vez
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

//    Pega os dados de um funcionario dependendo da sua categoria para obter os dados especificos
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

//    Pega os dados de todos os funcionarios de todos os departamentos
    public String getTodosFuncionariosDepartamentos() {
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
//        Percorre o vetor de objetos de departamentos
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            Dados = Dados + "Nome do departamento: " + ListaDepartamentos[i].getNome() + "\n";
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                Dados += getDadosFuncionarios(ListaFuncionario[j]);
            }

        }
        return Dados;
    }

//    Retorna o resumo dos departamentos
    public String getGeral() {
        String Dados = "";
        double Salario = 0;
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
//        Percorre o vetor de objetos de departamentos
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
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
        }
        return Dados;
    }

//    Retorna todos os funcionarios tecnicos de todos os departamentos
    public String getTecnicos() {
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
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

    //    Retorna todos os docentes de todos os departamentos
    public String getDocentes() {
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
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

    //    Retorna todos os docentes efetivos de todos os departamentos
    public String getDocentesEfetivos() {
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
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

    //    Retorna todos os docentes substitutos de todos os departamentos
    public String getDocentesSubstitutos() {
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
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

    public String getNomeDepartamentoNumero(int Numero) {
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        return ListaDepartamentos[Numero].getNome();
    }

    public String getDepartamentoCodigoNumero(int Numero) {
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        return ListaDepartamentos[Numero].getCodigo();
    }

    public String getNomeDepartamentoCodigo(String Codigo) {
        String Nome = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            if (ListaDepartamentos[i].getCodigo().equals(Codigo)) {
                Nome = ListaDepartamentos[i].getNome();
            }
        }
        return Nome;
    }

//    Retorna os dados de um departamento especifico
    public String getExibirDepartamentoEspecifico(String Nome) {
        Departamento ResultadoDepartamento = null;
        double Salario = 0;
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
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

//    Este metodo eh utilizado na busca de um intervalo de salario total de um departamento retornando um vetor de departamentos
    public Departamento[] buscarFaixaDepartamento(double Minimo, double Maximo) {
        double SalarioTotal;
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        Departamento Departamento[] = new Departamento[1000];
//        Departamento[] Departamento = null;
        int Contador = 0;
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            SalarioTotal = 0;
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                SalarioTotal += calculoSalario(ListaFuncionario[j]);
            }
            if (SalarioTotal > Minimo && SalarioTotal < Maximo) {
                Departamento[Contador] = ListaDepartamentos[i];
                Contador++;
            }
        }
        return Departamento;
    }

//    Busca os departamentos dentro do total de salario estipulado pela entrada
    public String buscarFaixaDepartamentoString(double Minimo, double Maximo) {
        String Dados = "";
//        A linguagem forca a inicializacao do vetor de ponteiros de objetos, eh necessario checar se o objeto existe
        Departamento D[] = null;
        D = buscarFaixaDepartamento(Minimo, Maximo);
        if (D != null) {
            for (int i = 0; i < D.length; i++) {
                if (D[i] != null) {
                    Dados = Dados + getExibirDepartamentoEspecifico(D[i].getNome());
                }
            }
        }
        if (Dados.equals("")) {
            Dados = "Nenhum departamento foi encontrado";
        }
        return Dados;
    }

//    Busca os funcionarios dos departamentos em um vetor e verifica se esta dentro do intervalo estipulado
    public String buscarFuncionarioString(double Minimo, double Maximo) {
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            Funcionario ListaFuncionario[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                if (calculoSalario(ListaFuncionario[j]) > Minimo && calculoSalario(ListaFuncionario[j]) < Maximo) {
                    Dados = Dados + getDadosFuncionarios(ListaFuncionario[j]);
                }
            }
        }
        if (Dados.equals("")) {
            Dados = "Nenhum funcionário foi encontrado";
        }
        return Dados;
    }

//    Pega os vetores de funcionarios dos departamentos com o metodo que possui o retorno de codigo e comparando se eh igual
    public String getFuncionarioBuscaCodigo(String Codigo) {
        Funcionario F[];
        String Dados = "";
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            F = ListaDepartamentos[i].getListaFuncionario();
            int QuantidadeFuncionario = ListaDepartamentos[i].getQuantidadeFuncionario();
            for (int j = 0; j < QuantidadeFuncionario; j++) {
                if (F[j].getCodigo().equals(Codigo)) {
                    Dados = getDadosFuncionarios(F[j]);
                }
            }
        }
        if (Dados.equals("")) {
            Dados = "Não foi encontrado o funcionário com o código especificado";
        }
        return Dados;
    }

//    Pega os vetores de funcionarios dos departamentos com o metodo que possui o retorno de nome e comparando se eh igual
    public String getFuncionarioBuscaNome(String Nome) {
        Funcionario F[];
        String Dados = "";
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            Departamento ListaDepartamentos[] = Database.getDepartamentos();
            F = ListaDepartamentos[i].getListaFuncionario();
            int QuantidadeFuncionario = ListaDepartamentos[i].getQuantidadeFuncionario();
            for (int j = 0; j < QuantidadeFuncionario; j++) {
                if (F[j].getNome().equals(Nome)) {
                    Dados = getDadosFuncionarios(F[j]);
                }
            }
        }
        if (Dados.equals("")) {
            Dados = "Não foi encontrado o funcionário com o nome especificado";
        }
        return Dados;
    }

    public int getQuantidadeDepartamento() {
        return Database.getContadorDepartamento();
    }

    public boolean codigoRepetidoDepartamento(String Codigo) {
        boolean Repetido = false;
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            if (ListaDepartamentos[i].getCodigo().equals(Codigo)) {
                Repetido = true;
            }
        }
        return Repetido;
    }

    public boolean codigoRepetidoFuncionario(String Codigo) {
        boolean Repetido = false;
        Departamento ListaDepartamentos[] = Database.getDepartamentos();
        for (int i = 0; i < Database.getContadorDepartamento(); i++) {
            Funcionario ListaFuncionarios[] = ListaDepartamentos[i].getListaFuncionario();
            for (int j = 0; j < ListaDepartamentos[i].getQuantidadeFuncionario(); j++) {
                if (ListaFuncionarios[j].getCodigo().equals(Codigo)) {
                    Repetido = true;
                }
            }
        }
        return Repetido;
    }
}
