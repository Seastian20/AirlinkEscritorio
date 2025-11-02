package Modelo;

public class login {
    private int id;
    private String nombre;
    private String email;
    private String pass;
    private int rol;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public int getRol() { return rol; }
    public void setRol(int rol) { this.rol = rol; }
}
