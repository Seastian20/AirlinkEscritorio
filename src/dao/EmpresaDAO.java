package dao;

import java.sql.*;
import java.util.*;
import Modelo.Empresa;

public class EmpresaDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Empresa> listar() {
        List<Empresa> lista = new ArrayList<>();
        String sql = "SELECT * FROM empresa";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empresa e = new Empresa();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setRut(rs.getString("rut"));
                e.setActiva(rs.getBoolean("activa"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("❌ Error al listar empresas: " + ex.getMessage());
        }
        return lista;
    }

    public boolean agregar(Empresa e) {
        String sql = "INSERT INTO empresa(nombre, rut, activa) VALUES (?, ?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getRut());
            ps.setBoolean(3, e.isActiva());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("❌ Error al agregar empresa: " + ex.getMessage());
            return false;
        }
    }

    public boolean actualizar(Empresa e) {
        String sql = "UPDATE empresa SET nombre=?, rut=?, activa=? WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getRut());
            ps.setBoolean(3, e.isActiva());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("❌ Error al actualizar empresa: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM empresa WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("❌ Error al eliminar empresa: " + ex.getMessage());
            return false;
        }
    }
}
