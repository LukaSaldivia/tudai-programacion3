import java.util.Iterator;
import java.util.LinkedList;

public class ExistingRoads {
  private static LinkedList<Integer> res;
  public static <T> LinkedList<Integer> run(GrafoDirigido<T> G, int v){
    res = new LinkedList<>();
    LinkedList<Integer> recorridos = new LinkedList<>();

    for(Iterator<Integer> it = G.obtenerVertices(); it.hasNext(); ){
      int start = it.next();
      if(visit(G, start, start, v, false, recorridos) && start != v){
        res.add(start);
      }
    }

    return new LinkedList<>(res);
  } 

  private static <T> boolean visit(GrafoDirigido<T> G, int start, int current, int target, boolean found, LinkedList<Integer> recorridos){
    if (current == target) {
      found = true;
    }

    for(Iterator<Integer> it = G.obtenerAdyacentes(current); it.hasNext();){
      Integer n = it.next();
      if (!recorridos.contains(n)) {
        recorridos.add(n);
        found = visit(G, start, n, target, found, recorridos) || found;
        recorridos.remove(n);
      }
    }


    return found;

    




  }
}
