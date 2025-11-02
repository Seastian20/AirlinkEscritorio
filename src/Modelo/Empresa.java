package Modelo;

public class Empresa {
    private int id;
    private String nombre;
    private String rut;
    private boolean activa;

    public Empresa() {}

    public Empresa(int id, String nombre, String rut, boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.activa = activa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
}
