public class AerolineaMain {
    public static void main(String[] args) {

        Tablero t1 = new Tablero();
        t1.generarTablero();
        Persona p1 = new Persona("20655455-5","Gabriel",20);
        p1.GenerarReserva();
        p1.mostrarReservas();



    }
}
