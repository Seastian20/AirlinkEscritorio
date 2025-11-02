package Vista;

import Modelo.Usuario;
import dao.UsuarioDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuariosVista extends javax.swing.JFrame {
    
    private final UsuarioDAO dao = new UsuarioDAO();
    private DefaultTableModel modelo;

    public UsuariosVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        listar();
    }

    private void listar() {
        List<Usuario> lista = dao.listar();
        modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setRowCount(0);
        for (Usuario u : lista) {
            Object[] fila = {u.getId(), u.getNombre(), u.getCorreo(), u.getRol()};
            modelo.addRow(fila);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtPass.setText("");
        txtRol.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Usuarios - Airlink");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nombre", "Correo", "Rol"}
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        btnAgregar.setText("Agregar");
        btnActualizar.setText("Actualizar");
        btnEliminar.setText("Eliminar");
        btnRefrescar.setText("Refrescar");

        btnAgregar.addActionListener(e -> {
            Usuario u = new Usuario();
            u.setNombre(txtNombre.getText());
            u.setCorreo(txtCorreo.getText());
            u.setContraseña(txtPass.getText());
            u.setRol(txtRol.getText());
            if (dao.agregar(u)) {
                JOptionPane.showMessageDialog(this, "✅ Usuario agregado.");
                listar();
                limpiarCampos();
            }
        });

        btnActualizar.addActionListener(e -> {
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecciona un usuario para actualizar.");
                return;
            }
            Usuario u = new Usuario();
            u.setId(Integer.parseInt(txtId.getText()));
            u.setNombre(txtNombre.getText());
            u.setCorreo(txtCorreo.getText());
            u.setContraseña(txtPass.getText());
            u.setRol(txtRol.getText());
            if (dao.actualizar(u)) {
                JOptionPane.showMessageDialog(this, "✏️ Usuario actualizado.");
                listar();
                limpiarCampos();
            }
        });

        btnEliminar.addActionListener(e -> {
            int fila = tablaUsuarios.getSelectedRow();
            if (fila >= 0) {
                int id = (int) tablaUsuarios.getValueAt(fila, 0);
                if (dao.eliminar(id)) {
                    JOptionPane.showMessageDialog(this, "🗑️ Usuario eliminado.");
                    listar();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un usuario para eliminar.");
            }
        });

        btnRefrescar.addActionListener(e -> listar());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(txtNombre)
                            .addComponent(txtCorreo)
                            .addComponent(txtPass)
                            .addComponent(txtRol, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar)
                            .addComponent(btnRefrescar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefrescar))
                .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new UsuariosVista().setVisible(true));
    }

    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtRol;
}
