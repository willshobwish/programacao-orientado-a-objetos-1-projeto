/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author Willian
 */
public class Departamento {

    private String codigo;
    private String nome;
//    private double salario;
//    private String nivel;
//    private String funcao;
    private Funcionario ListaFuncionario[];
    private int contador;
    private int maximo = 1000;

    public Departamento() {
        ListaFuncionario = new Funcionario[maximo];
        int contador = 0;
    }

    public void adicionarFuncionario(Funcionario funcionarioObjeto) {
        if (contador < maximo) {
            ListaFuncionario[contador] = funcionarioObjeto;
            contador++;
        }
    }

    public void adicionarTecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao) {
        Tecnico T = new Tecnico(codigo, nome, salario, categoria, nivel, funcao);
        adicionarFuncionario(T);
    }

    public void adicionarDocenteEfetivo(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, String area) {
        Efetivo DocenteEfetivo = new Efetivo(codigo, nome, salario, categoria, nivel, titulacao, area);
        adicionarFuncionario(DocenteEfetivo);

    }

    public void adicionarDocenteSubstituto(String codigo, String nome, double salario, String categoria, String nivel, String titulacao, int cargaHoraria) {
        Substituto DocenteSubstituto = new Substituto(codigo, nome, salario, categoria, nivel, titulacao, cargaHoraria);
        adicionarFuncionario(DocenteSubstituto);
    }

    public String getDados(int numero) {
        switch (ListaFuncionario[numero].getCategoria().toString()) {
            case "Docente efetivo":
                Tecnico tecnico = (Tecnico) ListaFuncionario[numero];
                String codigo = tecnico.getCodigo();
                String nome = tecnico.getNome();
                String salario = Double.toString(tecnico.getSalario());
                String nivel = tecnico.getNivel();
                String funcao = tecnico.getFuncao();
                String info = """
                      Codigo:%s
                      Nome:%s
                      Salario:%s
                      Nivel:%s
                      Funcao:%s
                      """.formatted(codigo, nome, salario, nivel, funcao);
                return info;
            default:
                throw new AssertionError();
        }
//        if (ListaFuncionario[numero].getCategoria().toString().equals("Docente efetivo")) {
//            Tecnico tecnico = (Tecnico) ListaFuncionario[numero];
//            String codigo = tecnico.getCodigo();
//            String nome = tecnico.getNome();
//            String salario = Double.toString(tecnico.getSalario());
//            String nivel = tecnico.getNivel();
//            String funcao = tecnico.getFuncao();
//            String info = """
//                      Codigo:%s
//                      Nome:%s
//                      Salario:%s
//                      Nivel:%s
//                      Funcao:%s
//                      """.formatted(codigo, nome, salario, nivel, funcao);
//            return info;
//        }
    }

    public String getCodigo() {
        return codigo;
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
