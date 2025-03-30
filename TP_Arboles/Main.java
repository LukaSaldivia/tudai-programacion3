public class Main {
  public static void main(String[] args) {
    Tree tree = new Tree();


    tree.add(6);
    tree.add(2);
    tree.add(1);
    tree.add(4);
    tree.add(10);
    tree.add(8);
    tree.add(7);
    tree.add(9);
    tree.add(19);
    tree.add(12);
    tree.add(11);
    tree.add(5);

    Integer K = 8;    
      
    System.out.println(tree);

    System.out.println(tree.getLeafsGreaterThan(K));


  }
}
