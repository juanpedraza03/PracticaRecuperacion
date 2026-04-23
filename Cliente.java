import java.time.LocalDateTime;

public class Cliente {
    private int id;
    private String nombre;
    private String tipoServicio;
    private LocalDateTime horaLlegada;
    private boolean atendido;

    public Cliente(int id, String nombre, String tipoServicio) {
        this.id = id;
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.horaLlegada = LocalDateTime.now();
        this.atendido = false;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public boolean isAtendido() {
        return atendido;
    }

    @Override
    public String toString() {
        return "Turno: " + id +
               " | Nombre: " + nombre +
               " | Servicio: " + tipoServicio +
               " | Hora: " + horaLlegada +
               " | Atendido: " + atendido;
    }
}