/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaescritorio;

import Vista.Login;

/**
 *
 * @author seba_
 */
public class SistemaEscritorio {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
   java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Login().setVisible(true);
        }
    });
}
}   