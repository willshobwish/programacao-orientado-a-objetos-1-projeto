/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Codigo;

import Interface.NovoCadastro;

/**
 *
 * @author Willian
 */
public class IUPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form IUPrincipal
     */
    public IUPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraDeMenu = new javax.swing.JMenuBar();
        Cadastro = new javax.swing.JMenu();
        NovoCadastro = new javax.swing.JMenuItem();
        Relatorio = new javax.swing.JMenu();
        Geral = new javax.swing.JMenuItem();
        ResumoDepartamento = new javax.swing.JMenuItem();
        ResumoDepartamentoGasto = new javax.swing.JMenuItem();
        FuncionarioSalarioEspecifico = new javax.swing.JMenuItem();
        Exibir = new javax.swing.JMenu();
        TodosFuncionarios = new javax.swing.JMenuItem();
        TodosTecnicos = new javax.swing.JMenuItem();
        TodosDocentes = new javax.swing.JMenuItem();
        TodosDocentesEfetivos = new javax.swing.JMenuItem();
        TodosDocentesSubstitutos = new javax.swing.JMenuItem();
        InformacoesDepartamento = new javax.swing.JMenuItem();
        Buscar = new javax.swing.JMenu();
        FuncionarioCodigo = new javax.swing.JMenuItem();
        FuncionarioNome = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Faculdade");

        Cadastro.setText("Cadastro");
        Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroActionPerformed(evt);
            }
        });

        NovoCadastro.setText("Novo cadastro");
        NovoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoCadastroActionPerformed(evt);
            }
        });
        Cadastro.add(NovoCadastro);

        BarraDeMenu.add(Cadastro);

        Relatorio.setText("Relatório");

        Geral.setText("Geral");
        Geral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeralActionPerformed(evt);
            }
        });
        Relatorio.add(Geral);

        ResumoDepartamento.setText("Resumo dos departamentos");
        Relatorio.add(ResumoDepartamento);

        ResumoDepartamentoGasto.setText("Resumo dos departamentos com gasto em faixa específica");
        Relatorio.add(ResumoDepartamentoGasto);

        FuncionarioSalarioEspecifico.setText("Funcionários com salário em faixa específica");
        Relatorio.add(FuncionarioSalarioEspecifico);

        BarraDeMenu.add(Relatorio);

        Exibir.setText("Exibir");

        TodosFuncionarios.setText("Todos os funcionários");
        Exibir.add(TodosFuncionarios);

        TodosTecnicos.setText("Todos os técnicos");
        Exibir.add(TodosTecnicos);

        TodosDocentes.setText("Todos os docentes");
        Exibir.add(TodosDocentes);

        TodosDocentesEfetivos.setText("Todos os docentes efetivos");
        Exibir.add(TodosDocentesEfetivos);

        TodosDocentesSubstitutos.setText("Todos os docentes substitutos");
        Exibir.add(TodosDocentesSubstitutos);

        InformacoesDepartamento.setText("Informações de um departamento");
        Exibir.add(InformacoesDepartamento);

        BarraDeMenu.add(Exibir);

        Buscar.setText("Buscar");

        FuncionarioCodigo.setText("Funcionários pelo código");
        Buscar.add(FuncionarioCodigo);

        FuncionarioNome.setText("Funcionários pelo nome");
        Buscar.add(FuncionarioNome);

        BarraDeMenu.add(Buscar);

        setJMenuBar(BarraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_CadastroActionPerformed

    private void GeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeralActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_GeralActionPerformed

    private void NovoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoCadastroActionPerformed
        // TODO add your handling code here:
        NovoCadastro NovoCadastroInterface = new NovoCadastro(this, true);
        NovoCadastroInterface.setLocationRelativeTo(this);
        NovoCadastroInterface.setVisible(true);
    }//GEN-LAST:event_NovoCadastroActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {;
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(IUPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new IUPrincipal().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraDeMenu;
    private javax.swing.JMenu Buscar;
    private javax.swing.JMenu Cadastro;
    private javax.swing.JMenu Exibir;
    private javax.swing.JMenuItem FuncionarioCodigo;
    private javax.swing.JMenuItem FuncionarioNome;
    private javax.swing.JMenuItem FuncionarioSalarioEspecifico;
    private javax.swing.JMenuItem Geral;
    private javax.swing.JMenuItem InformacoesDepartamento;
    private javax.swing.JMenuItem NovoCadastro;
    private javax.swing.JMenu Relatorio;
    private javax.swing.JMenuItem ResumoDepartamento;
    private javax.swing.JMenuItem ResumoDepartamentoGasto;
    private javax.swing.JMenuItem TodosDocentes;
    private javax.swing.JMenuItem TodosDocentesEfetivos;
    private javax.swing.JMenuItem TodosDocentesSubstitutos;
    private javax.swing.JMenuItem TodosFuncionarios;
    private javax.swing.JMenuItem TodosTecnicos;
    // End of variables declaration//GEN-END:variables
}
