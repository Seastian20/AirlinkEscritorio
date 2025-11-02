package dao;

import Modelo.Usuario;
import java.sql.*;
import java.util.*;

public class LoginDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    // --- LOGIN ---
    public Usuario log(String correo, String contraseña) {
        Usuario u = null;
        String sql = "SELECT * FROM usuario WHERE email = ? AND contrasena = ?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombreUsuario"));
                u.setCorreo(rs.getString("email"));
                u.setContraseña(rs.getString("contrasena"));
                u.setRol(String.valueOf(rs.getInt("idRol")));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error en login: " + e.getMessage());
        }
        return u;
    }

    // --- REGISTRO ---
    public boolean registrar(Usuario reg) {
        String sql = "INSERT INTO usuario (nombreUsuario, email, contrasena, idRol) VALUES (?, ?, ?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo()); // ✅ Aquí antes decía getEmail()
            ps.setString(3, reg.getContraseña());
            ps.setInt(4, Integer.parseInt(reg.getRol()));
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    // --- LISTAR ---
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombreUsuario"));
                u.setCorreo(rs.getString("email"));
                u.setRol(String.valueOf(rs.getInt("idRol")));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }
}
