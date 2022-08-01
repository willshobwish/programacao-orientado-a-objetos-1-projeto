/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author Willian
 */
public class Controle {

    public static void main(String[] args) {
        IUPrincipal InterfaceMenu = new IUPrincipal();
        InterfaceMenu.setVisible(true);
        InterfaceMenu.setTitle("Sistema faculdade");
        InterfaceMenu.toFront();
    }
}
