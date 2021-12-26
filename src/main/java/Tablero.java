import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tablero {
    public Tablero() {
    }

    private void linea8(){
        List<String> linea8=  List.of("A8","B8","C8","D8");
        System.out.println(linea8);

    }
    private void linea7(){
        List<String> linea7=  List.of("A7","B7","C7","D7");
        System.out.println(linea7);
    }
    private void linea6(){
        List<String> linea6=  List.of("A6","B6","C6","D6");
        System.out.println(linea6);
    }
    private void linea5(){
        List<String> linea5=  List.of("A5","B5","C5","D5");
        System.out.println(linea5);
    }
    private void linea4(){
        List<String> linea4=  List.of("A4","B4","C4","D4");
        System.out.println(linea4);
    }
    private void linea3(){
        List<String> linea3=  List.of("A3","B3","C3","D3");
        System.out.println(linea3);
    }
    private void linea2(){
        List<String> linea2=  List.of("A2","B2","C2","D2");
        System.out.println(linea2);
    }
    private void linea1(){
        List<String> linea1=  List.of("A1","B1","C1","D1");
        System.out.println(linea1);
    }

    public void generarTablero(){
        linea8();
        linea7();
        linea6();
        linea5();
        linea4();
        linea3();
        linea2();
        linea1();
    }

    public void buscarEnTabla(String a){
        List<String> linea8=  List.of("A8","B8","C8","D8","\n");
        List<String> linea7=  List.of("A7","B7","C7","D7","\n");
        List<String> linea6=  List.of("A6","B6","C6","D6","\n");
        List<String> linea5=  List.of("A5","B5","C5","D5","\n");
        List<String> linea4=  List.of("A4","B4","C4","D4","\n");
        List<String> linea3=  List.of("A3","B3","C3","D3","\n");
        List<String> linea2=  List.of("A2","B2","C2","D2","\n");
        List<String> linea1=  List.of("A1","B1","C1","D1","\n");


        List<String> tablero =
                Stream.of(linea8,linea7,linea6,linea5,linea4,linea3,linea2,linea1)
                        .flatMap(p->p.stream())
                        .collect(Collectors.toList());

        boolean busqueda = tablero.stream().anyMatch(p->p.equals(a));
        if (busqueda == true){
            List < String> nuevoTablero =
                    tablero.stream()
                            .map(p-> p.replace(a,"*"))
                            .collect(Collectors.toList());
            System.out.println(nuevoTablero);

            System.out.println("Asiento Reservado");

        }
        else{
            System.out.println("El asiento no esta disponible");
        }
    }
}
