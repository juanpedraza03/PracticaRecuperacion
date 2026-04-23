import java.time.LocalDateTime;

public class PaginaWeb {
    String url;
    String titulo;
    LocalDateTime fechaAcceso;

    public PaginaWeb(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
        this.fechaAcceso = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
               " | URL: " + url +
               " | Fecha: " + fechaAcceso;
    }
}