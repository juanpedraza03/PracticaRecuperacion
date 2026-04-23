import java.util.LinkedList;
import java.util.Queue;

public class ColaBanco {

    private Queue<Cliente> cola;
    private Queue<Cliente> atendidos;
    private int contadorTurnos;

    public ColaBanco() {
        cola = new LinkedList<>();
        atendidos = new LinkedList<>();
        contadorTurnos = 1;
    }

    public void encolar(String nombre, String tipoServicio) {

        if (!tipoServicio.equalsIgnoreCase("Retiro") &&
            !tipoServicio.equalsIgnoreCase("Consignación") &&
            !tipoServicio.equalsIgnoreCase("Asesoría")) {

            System.out.println(" Tipo de servicio inválido");
            return;
        }

        Cliente cliente = new Cliente(contadorTurnos++, nombre, tipoServicio);
        cola.add(cliente);

        System.out.println(" Cliente agregado correctamente");
    }

    public void desencolar() {
        if (cola.isEmpty()) {
            System.out.println(" No hay clientes en espera");
            return;
        }

        Cliente cliente = cola.poll();
        cliente.setAtendido(true);
        atendidos.add(cliente);

        System.out.println(" Atendiendo a: " + cliente);
    }

    public void peek() {
        if (cola.isEmpty()) {
            System.out.println(" No hay clientes en espera");
        } else {
            System.out.println(" Siguiente cliente: " + cola.peek());
        }
    }

    public void verCola() {
        if (cola.isEmpty()) {
            System.out.println(" Cola vacía");
            return;
        }

        System.out.println("\n Clientes en espera:");
        for (Cliente c : cola) {
            System.out.println(c);
        }
    }

    public void mostrarTurnos() {
        System.out.println("\n ATENDIDOS:");
        if (atendidos.isEmpty()) {
            System.out.println("  (Ninguno)");
        } else {
            for (Cliente c : atendidos) {
                System.out.println(c);
            }
        }

        System.out.println("\n PENDIENTES:");
        if (cola.isEmpty()) {
            System.out.println("  (Ninguno)");
        } else {
            for (Cliente c : cola) {
                System.out.println(c);
            }
        }
    }
}