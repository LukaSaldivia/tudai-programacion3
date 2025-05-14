import java.util.Iterator;

public class DFS {
  private static int tiempo = 0;

  public static <T> int run(GrafoDirigido<T> G) {

		tiempo = 0;
		Iterator<Integer> it = G.obtenerVertices();

		while (it.hasNext()) {
			Vertice<T> v = G.getVertice(it.next());
			v.setColor('B');
		}

		it = G.obtenerVertices();

		while (it.hasNext()) {
			Vertice<T> v = G.getVertice(it.next());
			if (v.getColor() == 'B') {
				visit(v, G);
			}
		}

		return tiempo;
	}

	private static <T> void visit(Vertice<T> u, GrafoDirigido<T> G) {
		u.setColor('A');
		tiempo++;
		u.setTiempoInicial(tiempo);
		Iterator<Integer> it = G.obtenerAdyacentes(u.getId());

		while (it.hasNext()) {
			Vertice<T> v = G.getVertice(it.next());
			if (v.getColor() == 'B') {
				visit(v, G);
			}
		}

		u.setColor('N');
		u.setTiempoFinal(++tiempo);

	}
}
