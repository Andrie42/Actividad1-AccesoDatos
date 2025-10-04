public class Entrada {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        op.exportarObjetosFichero("src/resources/datos.csv");
        op.escribirObjeto("src/resources/datos.dat");
        op.leerObjeto("src/resources/datos.dat");
    }
}
