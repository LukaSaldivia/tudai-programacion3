package ejercicios;

import java.util.Iterator;
import java.util.LinkedList;
import grafo.*;

/* 
Se tiene un conjunto de salas comunicadas entre sí a través de puertas que se abren solamente en 
un sentido. Una de las salas se denomina entrada y la otra salida. Construir un algoritmo que 
permita ir desde la entrada a la salida atravesando la máxima cantidad de salas. Idea: podría 
representar el problema mediante un grafo dirigido, donde cada nodo es una habitación, y cada 
puerta es un arco dirigido hacia otra habitación. 
*/

public class Ejer1 {
  public static <T> LinkedList<Integer> run(GrafoDirigido<T> G, int i, int j) {
    LinkedList<Integer> res = new LinkedList<>(), longest = new LinkedList<>();
    res.add(i);

    if (backtracking(G, res, longest, i, j, false)) {
      return longest;
    }

    return null;
  }

  private static <T> boolean backtracking(GrafoDirigido<T> G, LinkedList<Integer> currentRoad, LinkedList<Integer> longestRoad,
      int currentId, int targetId, boolean found) {

    if (currentId == targetId) {
      found = true;
      if (currentRoad.size() > longestRoad.size()) {
        longestRoad.clear();
        longestRoad.addAll(currentRoad);
      }
    } else {
      for (Iterator<Integer> it = G.obtenerAdyacentes(currentId); it.hasNext();) {
        Integer id = it.next();

        if (!currentRoad.contains(id)) {

          currentRoad.add(id);

          found = backtracking(G, currentRoad, longestRoad, id, targetId, found) || found;

          currentRoad.removeLast();
        }
      }
    }

    return found;
  }
}
