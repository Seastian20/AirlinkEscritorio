package Modelo;

public class Equipo {
    private int id;
    private String patente;
    private int capacidad;
    private String tipoBus;

    public Equipo() {}

    public Equipo(int id, String patente, int capacidad, String tipoBus) {
        this.id = id;
        this.patente = patente;
        this.capacidad = capacidad;
        this.tipoBus = tipoBus;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public String getTipoBus() { return tipoBus; }
    public void setTipoBus(String tipoBus) { this.tipoBus = tipoBus; }
}
