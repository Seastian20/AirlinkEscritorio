package Vista;

import Modelo.Usuario;
import javax.swing.JOptionPane;
import Vista.UsuariosVista;

public class MenuAdmin extends javax.swing.JFrame {

    private Usuario usuarioActivo;

    public MenuAdmin(Usuario usuario) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.usuarioActivo = usuario;
        lblNombreUsuario.setText("Bienvenido, " + usuario.getNombre());
    }

    public MenuAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnEmpresas = new javax.swing.JButton();
        btnViajes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnUsuarios.addActionListener(e -> new UsuariosVista().setVisible(true));


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Administración - Airlink");

        jPanel1.setBackground(new java.awt.Color(35, 22, 81));

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsuario.setText("Bienvenido, ...");

        btnUsuarios.setText("Usuarios");
        btnEmpresas.setText("Empresas");
        btnViajes.setText("Viajes");
        btnCerrarSesion.setText("Cerrar sesión");

        btnCerrarSesion.addActionListener(evt -> {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Cerrar sesión?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                new Login().setVisible(true);
                this.dispose();
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblNombreUsuario)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblNombreUsuario)
                .addGap(40, 40, 40)
                .addComponent(btnUsuarios)
                .addGap(20, 20, 20)
                .addComponent(btnEmpresas)
                .addGap(20, 20, 20)
                .addComponent(btnViajes)
                .addGap(20, 20, 20)
                .addComponent(btnCerrarSesion)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        pack();
    }

    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEmpresas;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnViajes;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JPanel jPanel1;
}
