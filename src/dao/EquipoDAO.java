package dao;

import java.sql.*;
import java.util.*;
import Modelo.Equipo;

public class EquipoDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Equipo> listar() {
        List<Equipo> lista = new ArrayList<>();
        String sql = "SELECT * FROM equipo";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Equipo e = new Equipo();
                e.setId(rs.getInt("id"));
                e.setPatente(rs.getString("patente"));
                e.setCapacidad(rs.getInt("capacidad"));
                e.setTipoBus(rs.getString("tipo_bus"));
                lista.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("❌ Error al listar equipos: " + ex.getMessage());
        }
        return lista;
    }

    public boolean agregar(Equipo e) {
        String sql = "INSERT INTO equipo(patente, capacidad, tipo_bus) VALUES (?, ?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getPatente());
            ps.setInt(2, e.getCapacidad());
            ps.setString(3, e.getTipoBus());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("❌ Error al agregar equipo: " + ex.getMessage());
            return false;
        }
    }

    public boolean actualizar(Equipo e) {
        String sql = "UPDATE equipo SET patente=?, capacidad=?, tipo_bus=? WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getPatente());
            ps.setInt(2, e.getCapacidad());
            ps.setString(3, e.getTipoBus());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("❌ Error al actualizar equipo: " + ex.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM equipo WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("❌ Error al eliminar equipo: " + ex.getMessage());
            return false;
        }
    }
}
