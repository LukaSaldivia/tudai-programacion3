import java.util.Iterator;

public class IsCiclic {
  public static <T> boolean run(GrafoDirigido<T> G) {
    Iterator<Integer> it = G.obtenerVertices();

    while (it.hasNext()) {
      Vertice<T> v = G.getVertice(it.next());
      v.setColor('B');
    }

    it = G.obtenerVertices();

		while (it.hasNext()) {
			Vertice<T> v = G.getVertice(it.next());
			if (v.getColor() == 'B') {
				if(visit(v, G)){
          return true;
        }
			}
		}

    return false;
  }

  	private static <T> boolean visit(Vertice<T> u, GrafoDirigido<T> G) {
		u.setColor('A');
		Iterator<Integer> it = G.obtenerAdyacentes(u.getId());

		while (it.hasNext()) {
			Vertice<T> v = G.getVertice(it.next());
      if (v.getColor() != 'N') {
        return (v.getColor() == 'A') || visit(v, G);
      }
		}

		u.setColor('N');
    return false;

	}
}
