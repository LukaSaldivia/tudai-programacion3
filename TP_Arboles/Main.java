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

    // Integer K = 8;    
      
    // System.out.println(tree);

    // System.out.println(tree.getLeafsGreaterThan(K));

    UnorderedTreeInteger unI = new UnorderedTreeInteger();

    unI
    .goLeft()
    .goLeft()
    .setValue(14)
    .goPrev()
    .goRight()
    .goLeft()
    .setValue(7)
    .goPrev()
    .goRight()
    .setValue(-5)
    .goRoot()
    .goRight()
    .goLeft()
    .goRight()
    .setValue(9)
    .goRoot()
    .goRight()
    .goRight()
    .setValue(20);

    // System.out.println(unI);

    unI.fillNullishNodes();

    // System.out.println(unI);


    UnorderedTreeChar unC = new UnorderedTreeChar();

    unC
    .setValue('M')
    .goLeft()
    .setValue('A')
    .goLeft()
    .setValue('L')
    .goPrev()
    .goRight()
    .setValue('N')
    .goLeft()
    .setValue('A')
    .goPrev()
    .goRight()
    .setValue('O')
    .goRoot()
    .goRight()
    .setValue('I')
    .goRight()
    .setValue('O')
    .goPrev()
    .goLeft()
    .setValue('S')
    .goRight()
    .setValue('A')
    ;

    System.out.println(unC);

    System.out.println(unC.getWords(2));

    UnorderedTreeChar arbolL = new UnorderedTreeChar();

    arbolL
    .setValue('L')
    .goLeft()
    .setValue('U')
    .goLeft()
    .setValue('K')
    .goRight()
    .setValue('A')
    .goRoot()
    .goLeft()
    .goRight()
    .setValue('N')
    .goRight()
    .setValue('A')
    .goRoot()
    .goRight()
    .setValue('A')
    .goRight()
    .setValue('N')
    .goLeft()
    .setValue('U')
    .goRight()
    .setValue('S')
    .goRoot()
    .goRight()
    .goLeft()
    .setValue('G')
    ;


    System.out.println(arbolL);

    System.out.println(arbolL.getWords(2));

  }
}
