/*
Andressa Yida Pinheiro de Souza
Willian Yoshio Murayama
Projeto semestral de programacao orientado a objetos
 */
package Modelo;

public class Tecnico extends Funcionario {

    protected String funcao;

    public Tecnico(String codigo, String nome, double salario, String categoria, String nivel, String funcao) {
        super(codigo, nome, salario, categoria, nivel);
        this.funcao = funcao;
    }

    public String getDados() {
        String Dados = """
                       Código: %s
                       Nome: %s
                       Salário: R$%.2f
                       Categoria: %s
                       Nível: %s
                       Função: %s

                       """.formatted(codigo, nome, calcularSalario(), categoria, nivel, funcao);
        return Dados;
    }

    @Override
    double calcularSalario() {
        double salarioTemp = 0;
        switch (nivel) {
            case "T1":
                salarioTemp = salario * 1.1;
                break;
            case "T2":
                salarioTemp = salario * 1.2;
                break;
        }
        return salarioTemp;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getSalario() {
        return calcularSalario();
    }

    @Override
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getNivel() {
        return nivel;
    }

    @Override
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
