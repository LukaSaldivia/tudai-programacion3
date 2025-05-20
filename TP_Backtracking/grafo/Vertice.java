package grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Vertice<T> {

  int id, tiempoInicial, tiempoFinal;
  char color;

  HashSet<Arco<T>> arcos = new HashSet<>();

  public Vertice(int id) {
    this.id = Math.abs(id);
  }

  public void agregarArco(int verticeDestino, T etiqueta) {
    Arco<T> added = new Arco<>(this.getId(), verticeDestino, etiqueta);
    arcos.add(added);
  }

  public void borrarArco(int verticeDestino) {
    Arco<T> deleted = new Arco<>(this.getId(), verticeDestino, null);
    arcos.remove(deleted);
  }

  public boolean contieneArco(int verticeDestino) {
    Arco<T> contains = new Arco<T>(id, verticeDestino, null);
    return arcos.contains(contains);
  }

  public Arco<T> obtenerArco(int verticeDestino) {
    Arco<T> searched = new Arco<T>(id, verticeDestino, null);
    if (!arcos.contains(searched))
      return null;

    for (Arco<T> arco : arcos) {
      if (arco.equals(searched)) {
        return arco;
      }
    }

    return null;
  }

  public List<Integer> obtenerAdyacentes() {
    List<Integer> res = new ArrayList<>();
    for (Arco<T> arco : arcos) {
      res.add(arco.getVerticeDestino());
    }

    return res;

  }

  public List<Arco<T>> obtenerArcos() {
    List<Arco<T>> res = new ArrayList<>();

    for (Arco<T> arco : arcos) {
      res.add(arco);
    }

    return res;
  }

  public int getCantidadArcos() {
    return arcos.size();
  }

  public Iterator<Arco<T>> iterator() {
    return arcos.iterator();
  }

  public int getId() {
    return id;
  }

  public char getColor() {
    return color;
  }

  public void setColor(char color) {
    this.color = color;
  }

  public void setTiempoInicial(int tiempoInicial) {
    this.tiempoInicial = tiempoInicial;
  }

  public void setTiempoFinal(int tiempoFinal) {
    this.tiempoFinal = tiempoFinal;
  }



  @Override
  public String toString(){
    return "ID: "+getId();
  }

}
