package dao;

import java.sql.*;
import java.util.*;
import Modelo.Ruta;

public class RutaDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Ruta> listar() {
        List<Ruta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ruta";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ruta r = new Ruta();
                r.setId(rs.getInt("id"));
                r.setOrigen(rs.getString("origen"));
                r.setDestino(rs.getString("destino"));
                r.setDuracionHoras(rs.getInt("duracion_horas"));
                lista.add(r);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar rutas: " + e.getMessage());
        }
        return lista;
    }

    public boolean agregar(Ruta r) {
        String sql = "INSERT INTO ruta(origen, destino, duracion_horas) VALUES (?, ?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getOrigen());
            ps.setString(2, r.getDestino());
            ps.setInt(3, r.getDuracionHoras());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar ruta: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Ruta r) {
        String sql = "UPDATE ruta SET origen=?, destino=?, duracion_horas=? WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getOrigen());
            ps.setString(2, r.getDestino());
            ps.setInt(3, r.getDuracionHoras());
            ps.setInt(4, r.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar ruta: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM ruta WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar ruta: " + e.getMessage());
            return false;
        }
    }
}
