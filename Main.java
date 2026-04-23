import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Navegador navegador = new Navegador();
        ColaBanco banco = new ColaBanco();

        int opcion;

        do {
            System.out.println("== MENU PRINCIPAL ===");
            System.out.println("1. Navegador (Pilas)");
            System.out.println("2. Banco (Colas)");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    menuPilas(sc, navegador);
                    break;

                case 2:
                    menuColas(sc, banco);
                    break;
            }

        } while (opcion != 0);
    }

    public static void menuPilas(Scanner sc, Navegador nav) {
        int op;
        do {
            System.out.println("\n--- NAVEGADOR ---");
            System.out.println("1. Visitar página");
            System.out.println("2. Retroceder");
            System.out.println("3. Ver historial");
            System.out.println("0. Volver");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("URL: ");
                    String url = sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    nav.visitar(url, titulo);
                    break;

                case 2:
                    nav.retroceder();
                    break;

                case 3:
                    nav.mostrarHistorial();
                    break;
            }

        } while (op != 0);
    }

    public static void menuColas(Scanner sc, ColaBanco banco) {
        int op;

        do {
            System.out.println("\n--- BANCO ---");
            System.out.println("1. Llegada cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver siguiente");
            System.out.println("4. Ver cola");
            System.out.println("5. Ver turnos");
            System.out.println("0. Volver");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Tipo de servicio:");
                    System.out.println("1. Retiro");
                    System.out.println("2. Consignación");
                    System.out.println("3. Asesoría");
                    System.out.print("Seleccione: ");

                    int tipoOpcion = sc.nextInt();
                    sc.nextLine();

                    String tipoServicio = "";
                    switch (tipoOpcion) {
                        case 1: tipoServicio = "Retiro"; break;
                        case 2: tipoServicio = "Consignación"; break;
                        case 3: tipoServicio = "Asesoría"; break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }

                    if (tipoOpcion >= 1 && tipoOpcion <= 3) {
                        banco.encolar(nombre, tipoServicio);
                    }
                    break;

                case 2:
                    banco.desencolar();
                    break;

                case 3:
                    banco.peek();
                    break;

                case 4:
                    banco.verCola(); 
                    break;

                case 5:
                    banco.mostrarTurnos();
                    break;
            }

        } while (op != 0);
    }
}