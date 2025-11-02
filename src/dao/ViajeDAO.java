package dao;

import java.sql.*;
import java.util.*;
import Modelo.Viaje;

public class ViajeDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Viaje> listar() {
        List<Viaje> lista = new ArrayList<>();
        String sql = "SELECT * FROM viaje";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Viaje v = new Viaje();
                v.setId(rs.getInt("id"));
                v.setIdRuta(rs.getInt("id_ruta"));
                v.setIdEquipo(rs.getInt("id_equipo"));
                v.setFechaSalida(rs.getDate("fecha_salida"));
                v.setPrecio(rs.getDouble("precio"));
                lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar viajes: " + e.getMessage());
        }
        return lista;
    }

    public boolean agregar(Viaje v) {
        String sql = "INSERT INTO viaje(id_ruta, id_equipo, fecha_salida, precio) VALUES (?, ?, ?, ?)";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getIdRuta());
            ps.setInt(2, v.getIdEquipo());
            ps.setDate(3, new java.sql.Date(v.getFechaSalida().getTime()));
            ps.setDouble(4, v.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al agregar viaje: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM viaje WHERE id=?";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar viaje: " + e.getMessage());
            return false;
        }
    }
}
