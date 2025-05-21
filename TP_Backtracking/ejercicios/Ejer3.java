package ejercicios;

import java.util.LinkedList;

// Suma de subconjuntos. Dados n números positivos distintos, se desea encontrar todas las  combinaciones de esos números tal que la suma sea igual a M.

public class Ejer3 {

  private static LinkedList<LinkedList<Integer>> res;

  public static LinkedList<LinkedList<Integer>> run(Integer[] conjunto, int objetivo){
     res = new LinkedList<>();
     LinkedList<Integer> parcial = new LinkedList<>();

     for (int i = 0; i < conjunto.length; i++) {
      parcial.add(conjunto[i]);
      backtracking(conjunto, i, parcial, objetivo);
      parcial.remove(conjunto[i]);
     }
    
    return res;
  }

  private static void backtracking(Integer[] conjunto, int index, LinkedList<Integer> parcial, int objetivo){
    int sum = sum(parcial);

    if (sum > objetivo)
    return;

    if (sum == objetivo) {
      res.add(new LinkedList<>(parcial));

    }else{
      for (int i = 1; i < conjunto.length - index; i++) {
        if (parcial.contains(conjunto[index + i]))
        continue;

        parcial.add(conjunto[index + i]);
        backtracking(conjunto, index + i, parcial, objetivo);
        parcial.remove(conjunto[index + i]);

      }
    }
  }

    private static int sum(LinkedList<Integer> lista) {
    int suma = 0;
    for (Integer n : lista) {
      suma += n;
    }

    return suma;
  }
  
}
