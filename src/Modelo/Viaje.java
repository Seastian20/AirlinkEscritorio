package Modelo;

import java.util.Date;

public class Viaje {
    private int id;
    private int idRuta;
    private int idEquipo;
    private Date fechaSalida;
    private double precio;

    public Viaje() {}

    public Viaje(int id, int idRuta, int idEquipo, Date fechaSalida, double precio) {
        this.id = id;
        this.idRuta = idRuta;
        this.idEquipo = idEquipo;
        this.fechaSalida = fechaSalida;
        this.precio = precio;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdRuta() { return idRuta; }
    public void setIdRuta(int idRuta) { this.idRuta = idRuta; }
    public int getIdEquipo() { return idEquipo; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }
    public Date getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(Date fechaSalida) { this.fechaSalida = fechaSalida; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
}
