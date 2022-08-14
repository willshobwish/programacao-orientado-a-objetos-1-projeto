/*
Andressa Yida Pinheiro de Souza
Willian Yoshio Murayama
Projeto semestral de programacao orientado a objetos
 */
package Modelo;

public class Departamento {

    private String codigo;
    private String nome;
    private Funcionario ListaFuncionario[];
    private int ContadorFuncionario = 0;
    private int Maximo = 1000;

    public Departamento(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        ListaFuncionario = new Funcionario[Maximo];
    }

    public void adicionarFuncionario(Funcionario NovoFuncionario) {
        if (ContadorFuncionario < Maximo) {
            ListaFuncionario[ContadorFuncionario] = NovoFuncionario;
            ContadorFuncionario++;
        }
    }

    public void adicionarTecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao) {
        Tecnico Tecnico = new Tecnico(codigo, nome, salario, categoria, nivel, funcao);
        adicionarFuncionario(Tecnico);
    }

    public void adicionarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, String area) {
        Efetivo DocenteEfetivo = new Efetivo(codigo, nome, salario, categoria, nivel, titulacao, area);
        adicionarFuncionario(DocenteEfetivo);

    }

    public void adicionarDocenteSubstituto(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, int cargaHoraria) {
        Substituto DocenteSubstituto = new Substituto(codigo, nome, salario, categoria, nivel, titulacao, cargaHoraria);
        adicionarFuncionario(DocenteSubstituto);
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidadeFuncionario() {
        return ContadorFuncionario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario[] getListaFuncionario() {
        return ListaFuncionario;
    }

    public void setListaFuncionario(Funcionario[] ListaFuncionario) {
        this.ListaFuncionario = ListaFuncionario;
    }

}
