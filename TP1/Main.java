public class Main {
  public static void main(String[] args) {
    MySimpleLinkedList<Integer> listaA = new MySimpleLinkedList<Integer>();
    MySimpleLinkedList<Integer> listaB = new MySimpleLinkedList<Integer>();
    MySimpleLinkedList<String> listaC = new MySimpleLinkedList<String>();


    listaA.insertFront(4);
    listaA.insertFront(2);
    listaA.insertFront(3);
    listaA.insertFront(1);

    listaB.insertFront(3);
    listaB.insertFront(4);
    listaB.insertFront(2);
    listaB.insertFront(1);

    // System.out.println(listaA);
    // System.out.println(listaB);

    System.out.println(mergeAndSort(listaA, listaB));

    listaC.insertFront("Alicia");
    listaC.insertFront("Carolina");
    listaC.insertFront("Luka");
    listaC.insertFront("Luna");
    listaC.insertFront("Gerardo");
    listaC.insertFront("Melany");
    listaC.insertFront("Yenny");
    listaC.insertFront("Cristian");
    listaC.insertFront("Tincho");

    MySimpleLinkedList.sort2(listaC);

    System.out.println(listaC);

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

}