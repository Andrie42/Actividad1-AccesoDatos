package model;

import java.io.Serial;
import java.io.Serializable;

public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 456L;
    private int id;
    private int clienteId;
    private String producto;
    private int cantidad;

    // Constructores:
    public Pedido() {
    }

    public Pedido(int id, int clienteId, String producto, int cantidad) {
        this.id = id;
        this.clienteId = clienteId;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters and setters:
    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // toString:

    @Override
    public String toString() {
        return String.format("%d, %d, %s, %d\n", id, clienteId, producto, cantidad);
    }
}
