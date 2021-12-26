
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Persona {

    private String rut;
    private String nombre;
    private int edad;
    private List<String> reservas = new ArrayList<>();

    public Persona(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    public void GenerarReserva(){
        Scanner lectura = new Scanner(System.in);
        Tablero t2 = new Tablero();
        System.out.println("¿Cuantos asientos va a querer?");
        int respuesta1 = lectura.nextInt();
        for (int i = 0; i<respuesta1;i++){
            String respuesta = preguntarAsiento(lectura);
            AgregarReserva(respuesta);
            t2.buscarEnTabla(respuesta);
        }

    }

    private void AgregarReserva(String respuesta) {
        reservas.add(respuesta);
    }

    private String preguntarAsiento(Scanner lectura) {
        System.out.println("¿Que asiento va a querer?");
        String respuesta = lectura.next();
        return respuesta;
    }

    public void mostrarReservas(){
        Long numerosReservas = reservas.stream().count();
        System.out.println("Tiene estos asientos reservados: " + numerosReservas);
        reservas.stream().forEach(p-> System.out.println(p));

    }

    public void mostrarTableroReservas(){
        List<String> linea8=  List.of("A8","B8","C8","D8","\n");
        List<String> linea7=  List.of("A7","B7","C7","D7","\n");
        List<String> linea6=  List.of("A6","B6","C6","D6","\n");
        List<String> linea5=  List.of("A5","B5","C5","D5","\n");
        List<String> linea4=  List.of("A4","B4","C4","D4","\n");
        List<String> linea3=  List.of("A3","B3","C3","D3","\n");
        List<String> linea2=  List.of("A2","B2","C2","D2","\n");
        List<String> linea1=  List.of("A1","B1","C1","D1","\n");

        String reserva = reservas.stream().toString();

        List<String> tablero =
                Stream.of(linea8,linea7,linea6,linea5,linea4,linea3,linea2,linea1)
                        .flatMap(p->p.stream())
                        .collect(Collectors.toList());

        List < String> nuevoTablero =
                tablero.stream()
                        .map(p-> p.replace(reserva,"*"))
                        .collect(Collectors.toList());
        System.out.println(nuevoTablero);
    }


}
