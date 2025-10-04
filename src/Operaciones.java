import model.Cliente;
import model.Pedido;

import java.io.*;
import java.util.ArrayList;

public class Operaciones {
    Cliente cliente1 = new Cliente(1, "Laura", "laura@gmail.com");
    Cliente cliente2 = new Cliente(2, "Luis", "luis@gmail.com");
    Cliente cliente3 = new Cliente(3, "Martina", "martina@gmail.com");
    Cliente clienteLectura;
    Cliente[] clientes = {cliente1, cliente2, cliente3};

    Pedido pedido1 = new Pedido(1, 3, "Camisa lino", 2);
    Pedido pedido2 = new Pedido(2, 1, "Pantalón vaquero", 1);
    Pedido pedido3 = new Pedido(3, 2, "Par calcetines", 3);
    Pedido pedidoLectura;
    Pedido[] pedidos = {pedido1, pedido2, pedido3};


    public void exportarObjetosFichero(String path) {

        File file = new File(path);
        PrintWriter pw = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            pw = new PrintWriter(file);

            //Exportar clientes
//            pw.println("id,nombre,correo");
//            for (Cliente c : clientes) {
//                pw.println(c.toString());
//            }

            //exportar pedidos
            pw.println("id,clienteId,producto,cantidad");
            for(Pedido p : pedidos){
                pw.println(p.toString());
            }

        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
            ;
        } finally {
            try {
                pw.close();
            } catch (Exception e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void escribirObjeto(String path) {
        File file = new File(path);
        ObjectOutputStream oos = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Se ha intentado crear el archivo, pero no tienes permisos de escritura");
            }
        }
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));

            // Escribir cliente
//            for (Cliente cliente : clientes) {
//                oos.writeObject(cliente);
//            }

            // Escribir pedido
            for (Pedido pedido : pedidos) {
                oos.writeObject(pedido);
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (IOException e) {
            System.out.println("Error al escribir el objeto, no tienes permisos de escritura");
        } finally {
            try {
                oos.close();
            } catch (IOException | NullPointerException e) {
                System.out.println("Error al cerrar oos");
            }
        }

    }

    public void leerObjeto(String path) {
        File file = new File(path);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));

            //Leer clientes
//            while ((clienteLectura = (Cliente) ois.readObject()) != null) {
//                ArrayList<Cliente> clientesLectura = new ArrayList<>();
//                clientesLectura.add(clienteLectura);
//                for (Cliente cliente : clientesLectura) {
//                    System.out.println(cliente.toString());
//                }
//            }

            //Leer pedido
            while ((pedidoLectura = (Pedido) ois.readObject()) != null){
                ArrayList<Pedido> pedidosLectura = new ArrayList<>();
                pedidosLectura.add(pedidoLectura);
                for (Pedido pedido : pedidosLectura) {
                    System.out.println(pedido.toString());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la clase de lectura");
        } catch (EOFException e) {
            System.out.println("Fin de la lectura");
        } catch (IOException e) {
            System.out.println("No tienes permisos de lectura");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("Error en el cerrado");
            }
        }

    }
}
