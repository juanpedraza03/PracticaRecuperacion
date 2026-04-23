import java.util.Stack;

public class Navegador {
    private Stack<PaginaWeb> historial = new Stack<>();

    public void visitar(String url, String titulo) {
        PaginaWeb pagina = new PaginaWeb(url, titulo);
        historial.push(pagina);
        System.out.println("Página visitada");
    }

    public void retroceder() {
        if (historial.size() > 1) {
            historial.pop();
            System.out.println("Regresando a: " + historial.peek());
        } else {
            System.out.println("No hay páginas para retroceder");
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacío");
        } else {
            for (PaginaWeb p : historial) {
                System.out.println(p);
            }
        }
    }
}