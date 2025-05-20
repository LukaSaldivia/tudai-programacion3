import ejercicios.Ejer1;
import ejercicios.Ejer2;
import grafo.*;
import misc.*;

public class Main {
  public static void main(String[] args) {

    // Mansion => Grafo
    // Sala => Nodo
    // Puerta => Arco
    GrafoDirigido<Boolean> mansion = new GrafoDirigido<>();

    // Creación de salas
    // Entrada
    mansion.agregarVertice(1);

    // Salida
    mansion.agregarVertice(10);

    mansion.agregarVertice(2);
    mansion.agregarVertice(3);
    mansion.agregarVertice(4);
    mansion.agregarVertice(5);
    mansion.agregarVertice(6);
    mansion.agregarVertice(7);
    mansion.agregarVertice(8);
    mansion.agregarVertice(9);

    // Conexiones
    mansion.agregarArco(1, 2, null);
    mansion.agregarArco(1, 3, null);

    mansion.agregarArco(2, 5, null);
    mansion.agregarArco(2, 4, null);

    mansion.agregarArco(4, 5, null);
    mansion.agregarArco(4, 7, null);
    mansion.agregarArco(4, 8, null);
    mansion.agregarArco(4, 10, null);

    mansion.agregarArco(5, 6, null);
    mansion.agregarArco(5, 9, null);

    mansion.agregarArco(6, 3, null);

    mansion.agregarArco(7, 8, null);

    mansion.agregarArco(8, 9, null);
    mansion.agregarArco(8, 10, null);

    mansion.agregarArco(9, 4, null);
    mansion.agregarArco(9, 8, null);

    // System.out.println(Ejer1.run(mansion, 1, 10));

    PorcionLaberinto[][] laberinto = {
      {new PorcionLaberinto(1, false, true, false, false), new PorcionLaberinto(6, false, false, true, false), new PorcionLaberinto(1, false, true, true, true), new PorcionLaberinto(8, false, true, false, true)},

      {new PorcionLaberinto(2, true, true, true, false), new PorcionLaberinto(5, false, true, true, true), new PorcionLaberinto(2, true, false, false, false), new PorcionLaberinto(2, true, true, false, false)},

      {new PorcionLaberinto(5, true, false, false, false), new PorcionLaberinto(3, true, false, true, false), new PorcionLaberinto(5, false, false, true, true), new PorcionLaberinto(8, true, false, false, true)}
    };

    System.out.println("shortest: "+Ejer2.run(laberinto, 1, 3, 1, 1));


  }

}