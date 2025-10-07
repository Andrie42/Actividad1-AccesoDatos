package model;

import java.io.Serial;
import java.io.Serializable;

public class Cliente implements Serializable {

    @Serial
    private static final long serialVersionUID = 123L;
    private int id;
    private String nombre;
    private String email;

    // Constructores:
    public Cliente() {
    }

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString
    @Override
    public String toString() {
        return String.format("%d,%s,%s",id,nombre,email);
    }

    

}

