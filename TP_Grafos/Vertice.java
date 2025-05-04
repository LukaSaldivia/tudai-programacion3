import java.util.Iterator;

public class Vertice<T> {
  int id;

  LinkedList<Arco<T>> arcos;

  public Vertice(int id){
    this.id = id;
    arcos = new LinkedList<Arco<T>>();
  }

  public void agregarArco(int verticeDestino, T etiqueta){
    Arco<T> added = new Arco<T>(id, verticeDestino, etiqueta);
    arcos.insertFront(added);
  }

  public void borrarArco(int verticeDestino){
    Arco<T> deleted = new Arco<T>(id, verticeDestino, null);
    arcos.remove(deleted);

  }

  public boolean contieneArco(int verticeDestino){
    Arco<T> contains = new Arco<T>(id, verticeDestino, null);
    return arcos.contains(contains);
  }

  public Arco<T> obtenerArco(int verticeDestino){
    Arco<T> res = new Arco<T>(id, verticeDestino, null);
    return arcos.get(res);
  }

  public int getCantidadArcos(){
    return arcos.size();
  }

  public int getId(){
    return id;
  }

  public Iterator<Arco<T>> iterator(){
    return arcos.iterator();
  }

  @Override
  public boolean equals(Object o) {
		try {
			Vertice<T> other = (Vertice<T>) o;
			return other.getId() == getId();
		} catch (Exception e) {
			return false;
		}
  }


}
