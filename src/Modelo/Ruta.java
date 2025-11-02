package Modelo;

public class Ruta {
    private int id;
    private String origen;
    private String destino;
    private int duracionHoras;

    public Ruta() {}

    public Ruta(int id, String origen, String destino, int duracionHoras) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.duracionHoras = duracionHoras;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public int getDuracionHoras() { return duracionHoras; }
    public void setDuracionHoras(int duracionHoras) { this.duracionHoras = duracionHoras; }
}
