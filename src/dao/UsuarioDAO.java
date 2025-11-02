package dao;

import java.sql.*;
import java.util.*;
import Modelo.Usuario;

public class UsuarioDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- LISTAR ---
    public List<Usuario> listar() {
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
                u.setContraseña(rs.getString("contrasena"));
                u.setRol(String.valueOf(rs.getInt("idRol")));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    // --- AGREGAR ---
    public boolean agregar(Usuario u) {
        String sql = "INSERT INTO usuario (nombreUsuario, email, contrasena, idRol) VALUES (?, ?, ?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getContraseña());
            ps.setInt(4, Integer.parseInt(u.getRol()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar usuario: " + e.getMessage());
            return false;
        }
    }

    // --- ACTUALIZAR ---
    public boolean actualizar(Usuario u) {
        String sql = "UPDATE usuario SET nombreUsuario=?, email=?, contrasena=?, idRol=? WHERE idUsuario=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getContraseña());
            ps.setInt(4, Integer.parseInt(u.getRol()));
            ps.setInt(5, u.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }

    // --- ELIMINAR ---
    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE idUsuario=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar usuario: " + e.getMessage());
            return false;
        }
    }

    // --- BUSCAR POR CORREO ---
    public Usuario buscarPorCorreo(String correo) {
        Usuario u = null;
        String sql = "SELECT * FROM usuario WHERE email=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
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
            System.out.println("❌ Error al buscar usuario: " + e.getMessage());
        }
        return u;
    }
}
