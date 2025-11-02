package Vista;

import javax.swing.*;
import Modelo.Usuario;

public class PanelPrincipal extends JFrame {

    private Usuario usuario;

    public PanelPrincipal(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        JLabel label = new JLabel("Bienvenido, " + usuario.getNombre() + " (" + usuario.getRol() + ")");
        label.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        getContentPane().add(label);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
    }
}
