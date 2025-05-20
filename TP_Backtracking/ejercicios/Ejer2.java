package ejercicios;

import java.util.LinkedList;

import misc.PorcionLaberinto;

/*
Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural y 
cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este, sur 
y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud de un 
camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría representarse 
el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y cuatro 
booleanos, uno para cada dirección a la que se permite ir desde allí. 
 */

public class Ejer2 {

  public static LinkedList<PorcionLaberinto> run(PorcionLaberinto[][] laberinto, int i1, int j1, int i2, int j2) {
    LinkedList<PorcionLaberinto> partial = new LinkedList<>(), shortest = new LinkedList<>();

    partial.add(laberinto[i1][j1]);

    backtracking(partial, shortest, i1, j1, i2, j2, laberinto);


    return shortest;
  }

  private static void backtracking(LinkedList<PorcionLaberinto> partial, LinkedList<PorcionLaberinto> shortest,
      int currentI, int currentJ,
      int targetI, int targetJ, PorcionLaberinto[][] laberinto) {

        System.out.println(partial);

    if (currentI == targetI && currentJ == targetJ) {
      if (sum(partial) < sum(shortest) || shortest.size() == 0) {
        shortest.clear();
        shortest.addAll(partial);

        return;
      }
    } else {

      if (currentJ - 1 >= 0) {
        PorcionLaberinto west = laberinto[currentI][currentJ - 1];
        if (west != null && west.isEastFree() && !partial.contains(west)) {
          partial.add(west);
          backtracking(partial, shortest, currentI, currentJ - 1, targetI, targetJ, laberinto);
          partial.remove(west);
        }
      }

      if (currentJ + 1 < laberinto[currentI].length) {
        PorcionLaberinto east = laberinto[currentI][currentJ + 1];
        if (east != null && east.isWestFree() && !partial.contains(east)) {
          partial.add(east);
          backtracking(partial, shortest, currentI, currentJ + 1, targetI, targetJ, laberinto);
          partial.remove(east);
        }
      }

      if (currentI - 1 >= 0) {
        PorcionLaberinto north = laberinto[currentI - 1][currentJ];
        if (north != null && north.isSouthFree() && !partial.contains(north)) {
          partial.add(north);
          backtracking(partial, shortest, currentI - 1, currentJ, targetI, targetJ, laberinto);
          partial.remove(north);
        }
      }

      if (currentI + 1 < laberinto.length) {
        PorcionLaberinto south = laberinto[currentI + 1][currentJ];
        if (south != null && south.isNorthFree() && !partial.contains(south)) {
          partial.add(south);
          backtracking(partial, shortest, currentI + 1, currentJ, targetI, targetJ, laberinto);
          partial.remove(south);
        }
      }
    }

  }

  private static int sum(LinkedList<PorcionLaberinto> lista) {
    int suma = 0;
    for (PorcionLaberinto porcionLaberinto : lista) {
      suma += porcionLaberinto.getValue();
    }

    return suma;
  }

}
