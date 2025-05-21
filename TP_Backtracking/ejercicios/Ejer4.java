package ejercicios;

import java.util.ArrayList;

// Partición de conjunto. Dado un conjunto de n enteros se desea encontrar, si existe, una partición en 
// dos subconjuntos disjuntos, tal que la suma de sus elementos sea la misma. 

public class Ejer4 {

  public static ArrayList<Integer>[] conjuntos;

  public static ArrayList<Integer>[] run(Integer[] conjunto) {
    conjuntos = new ArrayList[2];

    ArrayList<Integer> sub1 = new ArrayList<>(), sub2 = new ArrayList<>();
    sub1.add(conjunto[0]);

    for (int i = 1; i < conjunto.length; i++) {
      sub2.add(conjunto[i]);
    }

    backtracking(conjunto, sub1, sub2, 0);

    return conjuntos;
  }

  private static void backtracking(Integer[] conjunto, ArrayList<Integer> sub1, ArrayList<Integer> sub2, int index) {
    
    if (sub1.size() == 0 || sub2.size() == 0)
    return;

    if (equalSum(sub1, sub2)) {
      System.out.println("Holis");
      conjuntos[0] = new ArrayList<>(sub1);
      conjuntos[1] = new ArrayList<>(sub2);
    } else {
      for (int i = 1; i < conjunto.length - index; i++) {
        int indexOfSub2 = sub2.indexOf(conjunto[index + i]);
        sub1.add(sub2.get(indexOfSub2));
        sub2.remove(indexOfSub2);
        backtracking(conjunto, sub1, sub2, index + i);
        int indexOfSub1 = sub1.indexOf(conjunto[index + i]);
        sub2.add(sub1.get(indexOfSub1));
        sub1.remove(indexOfSub1);

      }
    }
  }

  private static int sum(ArrayList<Integer> lista) {
    int suma = 0;
    for (Integer n : lista) {
      suma += n;
    }

    return suma;
  }

  private static boolean equalSum(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
    return sum(lista1) == sum(lista2);
  }

}
