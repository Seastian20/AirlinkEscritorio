package dao;

import java.sql.*;
import java.util.*;
import Modelo.Terminal;

public class TerminalDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Terminal> listar() {
        List<Terminal> lista = new ArrayList<>();
        String sql = "SELECT * FROM terminal";
        try {
            con = Conexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Terminal t = new Terminal();
                t.setId(rs.getInt("id"));
                t.setNombre(rs.getString("nombre"));
                t.setCiudad(rs.getString("ciudad"));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar terminales: " + e.getMessage());
        }
        return lista;
    }
}
