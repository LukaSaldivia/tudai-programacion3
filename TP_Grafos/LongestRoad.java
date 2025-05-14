import java.util.Iterator;
import java.util.LinkedList;

public class LongestRoad {

  public static <T> LinkedList<Integer> run(GrafoDirigido<T> G, int i, int j){
    LinkedList<Integer> res = new LinkedList<>(), longest = new LinkedList<>();
    res.add(i);

    if (visit(G, res, longest, i, j, false)){
      return longest;
    }

    return new LinkedList<Integer>();

  }

  private static <T> boolean visit(GrafoDirigido<T> G, LinkedList<Integer> currentRoad, LinkedList<Integer> longestRoad, int currentId, int targetId, boolean found){

    if (currentId == targetId) {
      found = true;
      if (currentRoad.size() > longestRoad.size()) {
        longestRoad.clear();
        longestRoad.addAll(currentRoad);
      }
    }else{
      for(Iterator<Integer> it = G.obtenerAdyacentes(currentId); it.hasNext();){
        Integer id = it.next();

        if (!currentRoad.contains(id)) {
          
          currentRoad.add(id);
          
          found = visit(G, currentRoad, longestRoad, id, targetId, found) || found;
          
          currentRoad.removeLast();
        }
      }
    }

    return found;
  }

}
