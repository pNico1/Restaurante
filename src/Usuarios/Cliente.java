package Usuarios;

public class Cliente {
    private String nombre;
    private Mail email;
    private String telefono;
    private UserApp userApp;

    public Cliente(String nombre, Mail email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    public Cliente(String nombre, UserApp userApp, String telefono) {
        this.nombre = nombre;
        this.userApp = userApp;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email.getEmail(); }
    public String getTelefono() { return telefono; }

}