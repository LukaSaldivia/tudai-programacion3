import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

  LinkedList<Vertice<T>> vertices = new LinkedList<Vertice<T>>();
  

  public GrafoDirigido(){
    vertices = new LinkedList<Vertice<T>>();
  }

	@Override
	public void agregarVertice(int verticeId) {
		vertices.insertFront(new Vertice<T>(verticeId));
	}

	@Override
	public void borrarVertice(int verticeId) {
		vertices.remove(new Vertice<T>(verticeId));
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Vertice<T> target = new Vertice<T>(verticeId1), obtenido = vertices.get(target);
		obtenido.agregarArco(verticeId2, etiqueta);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Vertice<T> target = new Vertice<T>(verticeId1), obtenido = vertices.get(target);
		obtenido.borrarArco(verticeId2);		
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.contains(new Vertice<T>(verticeId));
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		Vertice<T> target = new Vertice<T>(verticeId1), obtenido = vertices.get(target);
		return obtenido.contieneArco(verticeId2);
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Vertice<T> target = new Vertice<T>(verticeId1), obtenido = vertices.get(target);
		return obtenido.obtenerArco(verticeId2);
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int res = 0;
		for (Vertice<T> vertice : vertices) {
			res += vertice.getCantidadArcos();
		}
		return res;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return null;
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		LinkedList<Arco<T>> res = new LinkedList<>();

		for (Vertice<T> vertice : vertices) {
				res.addAll(vertice.arcos); // TO-DO Rompe encapsulamiento
		}

		return res.iterator();
		
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		// TODO Auto-generated method stub
		return null;
	}

}