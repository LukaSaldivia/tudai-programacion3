import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

public class BFS {
  static ArrayBlockingQueue<Integer> fila;
  static int niveles = 0;

  public static <T> int run(GrafoDirigido<T> G) {
    niveles = 0;

    fila = new ArrayBlockingQueue<Integer>(G.cantidadVertices());

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

    return niveles;
  }

  private static <T> void visit(Vertice<T> u, GrafoDirigido<T> G) {
    u.setColor('N');
    fila.add(u.getId());

    int nivelActual = 1;
    int siguienteNivel = 0;

    while (!fila.isEmpty()) {

      for (int i = 0; i < nivelActual; i++) {
        int id = fila.poll();

        Iterator<Integer> it = G.obtenerAdyacentes(id);

        while (it.hasNext()) {
          Vertice<T> v = G.getVertice(it.next());
          if (v.getColor() == 'B') {
            v.setColor('N');
            fila.add(v.getId());
            siguienteNivel++;
          }
        }
      }

      if (siguienteNivel > 0) {
        niveles++;
        nivelActual = siguienteNivel;
        siguienteNivel = 0;
      } else {
        break;
      }
    }
  }


}
