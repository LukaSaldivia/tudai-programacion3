import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    MySimpleLinkedList<Integer> listaA = new MySimpleLinkedList<Integer>();
    MySimpleLinkedList<Integer> listaB = new MySimpleLinkedList<Integer>();
    MySimpleLinkedList<String> listaC = new MySimpleLinkedList<String>();

    listaA.insertFront(1);
    listaA.insertFront(4);
    listaA.insertFront(2);
    listaA.insertFront(3);

    listaB.insertFront(3);
    listaB.insertFront(4);
    listaB.insertFront(1);
    listaB.insertFront(2);

    // System.out.println(listaA);
    // System.out.println(listaB);

    // System.out.println(mergeAndSort(listaA, listaB));

    listaC.insertFront("A");
    listaC.insertFront("L");
    listaC.insertFront("B");
    listaC.insertFront("AB");
    listaC.insertFront("D");
    listaC.insertFront("T");
    listaC.insertFront("Y");
    listaC.insertFront("F");
    listaC.insertFront("Z");

    // System.out.println(listaC);
    MySimpleLinkedList.sort2(listaC);
    // System.out.println(listaC);

    MySimpleLinkedList<Integer> ordenada1 = new MySimpleLinkedList<Integer>();
    MySimpleLinkedList<Integer> ordenada2 = new MySimpleLinkedList<Integer>();

    ordenada1.insertFront(8);
    ordenada1.insertFront(6);
    ordenada1.insertFront(5);
    ordenada1.insertFront(2);
    ordenada1.insertFront(0);

    ordenada2.insertFront(7);
    ordenada2.insertFront(6);
    ordenada2.insertFront(2);
    ordenada2.insertFront(1);
    ordenada2.insertFront(0);

    System.out.println("Lista ordenada 1: " + ordenada1);
    System.out.println("Lista ordenada 2: " + ordenada2 + "\n ");
    System.out.println("Unión: " + mergeSorted(ordenada1, ordenada2));
    System.out.println("Diferencia (ordenada1 - ordenada2): " + diffSorted(ordenada1, ordenada2));
    System.out.println("Diferencia (ordenada2 - ordenada1): " + diffSorted(ordenada2, ordenada1) + "\n ");

    MySimpleLinkedList<Integer> ordenada3 = new MySimpleLinkedList<Integer>();
    MySimpleLinkedList<Integer> ordenada4 = new MySimpleLinkedList<Integer>();

    ordenada3.insertFront(5);
    ordenada3.insertFront(4);
    ordenada3.insertFront(3);
    ordenada3.insertFront(2);

    ordenada4.insertFront(3);
    ordenada4.insertFront(2);
    ordenada4.insertFront(1);
    ordenada4.insertFront(0);

    System.out.println("Lista ordenada 3: " + ordenada3);
    System.out.println("Lista ordenada 4: " + ordenada4 + "\n ");
    System.out.println("Unión: " + mergeSorted(ordenada3, ordenada4));
    System.out.println("Diferencia (ordenada3 - ordenada4): " + diffSorted(ordenada3, ordenada4));
    System.out.println("Diferencia (ordenada4 - ordenada3): " + diffSorted(ordenada4, ordenada3));

  }

  public static <T extends Comparable<T>> MySimpleLinkedList<T> mergeAndSort(
      MySimpleLinkedList<T> list1,
      MySimpleLinkedList<T> list2

  ) {
    MySimpleLinkedList<T> merge = new MySimpleLinkedList<T>();

    for (T t : list1) {
      if (list2.contains(t)) {
        merge.insertFront(t);
      }
    }

    MySimpleLinkedList.sort(merge);

    return merge;

  }

  public static <T extends Comparable<T>> MySimpleLinkedList<T> diffAndSort(
      MySimpleLinkedList<T> list1,
      MySimpleLinkedList<T> list2

  ) {
    MySimpleLinkedList<T> merge = new MySimpleLinkedList<T>();

    for (T t : list1) {
      if (!list2.contains(t)) {
        merge.insertFront(t);
      }
    }

    MySimpleLinkedList.sort(merge);

    return merge;

  }

  public static <T extends Comparable<T>> MySimpleLinkedList<T> mergeSorted(
      MySimpleLinkedList<T> list1,
      MySimpleLinkedList<T> list2) {
    MySimpleLinkedList<T> res = new MySimpleLinkedList<T>(),
        firstInverted = new MySimpleLinkedList<T>(),
        secondInverted = new MySimpleLinkedList<T>();

    // invirtiendo las listas para poder insertar de frente y que queden de menor a
    // mayor
    for (T t : list1) {
      firstInverted.insertFront(t);
    }

    for (T t : list2) {
      secondInverted.insertFront(t);
    }

    // unión de listas

    Iterator<T> iterator2 = secondInverted.iterator();
    T firstReference = iterator2.next();

    for (T t : firstInverted) {



      while (iterator2.hasNext()) {

        if (firstReference.compareTo(t) < 0) {
          break;
        }

        if (firstReference.equals(t)) {
          res.insertFront(firstReference);
        }

        firstReference = iterator2.next();

      }

      if (!iterator2.hasNext() && firstReference.equals(t)) {
        res.insertFront(t);
      }


    }

    return res;
  }

  public static <T extends Comparable<T>> MySimpleLinkedList<T> diffSorted(
      MySimpleLinkedList<T> list1,
      MySimpleLinkedList<T> list2) {
    MySimpleLinkedList<T> res = new MySimpleLinkedList<T>(), firstInverted = new MySimpleLinkedList<T>(),
        secondInverted = new MySimpleLinkedList<T>();
    for (T t : list1) {
      firstInverted.insertFront(t);
    }

    for (T t : list2) {
      secondInverted.insertFront(t);
    }

    // diferencia de listas

    Iterator<T> iterator2 = secondInverted.iterator();
    T firstReference = iterator2.next();

    for (T t : firstInverted) {
      
      if (!iterator2.hasNext() && !t.equals(firstReference)) {
        res.insertFront(t);
      }
      
      
      while (iterator2.hasNext()) {
        if (t.compareTo(firstReference) > 0) {
          res.insertFront(t);
          break;
        }

        if (firstReference.equals(t)) {
          firstReference = iterator2.next();
          break;
        }
        firstReference = iterator2.next();
        
      }



    }

    return res;
  }
}