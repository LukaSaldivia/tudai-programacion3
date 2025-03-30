import java.util.ArrayList;

public class Tree {

  private TreeNode root;

  public Tree() {
    this.root = null;
  }

  public void add(Integer value) {
    if (this.root == null)
      this.root = new TreeNode(value);
    else
      this.add(this.root, value);
  }

  private void add(TreeNode actual, Integer value) {

    if (actual.getValue() > value) {

      if (actual.getLeft() == null) {
        actual.setLeft(new TreeNode(value));
        return;
      }

      add(actual.getLeft(), value);
      return;
    }

    if (actual.getValue() < value) {

      if (actual.getRight() == null) {
        actual.setRight(new TreeNode(value));
        return;
      }

      add(actual.getRight(), value);
      return;
    }

  }

  public Integer getRoot() {

    if (this.root == null)
      return null;

    return this.root.getValue();
  }

  public boolean hasElem(Integer value) {
    return hasElem(root, value);
  }

  private boolean hasElem(TreeNode actual, Integer value) {

    if (actual == null) {
      return false;
    }

    if (actual.getValue().equals(value)) {
      return true;
    }

    return value < actual.getValue() ? hasElem(actual.getLeft(), value) : hasElem(actual.getRight(), value);
  }

  public boolean isEmpty() {
    return root == null;
  }

  public boolean delete(Integer value) {
    if (isEmpty()) {
      return false;
    }

    root = delete(root, value);
    return true;
  }

  private TreeNode delete(TreeNode actual, Integer value) {
    if (actual == null) {
      return null;
    }

    if (value < actual.getValue()) {
      actual.setLeft(delete(actual.getLeft(), value));
    } else if (value > actual.getValue()) {
      actual.setRight(delete(actual.getRight(), value));
    } else {
      // es una hoja
      if (actual.getLeft() == null && actual.getRight() == null) {
        return null;
      }

      // tiene un solo nodo
      if (actual.getLeft() == null) {
        return actual.getRight();
      }

      if (actual.getRight() == null) {
        return actual.getLeft();
      }

      TreeNode nuevo = getMinNode(actual.getRight());
      actual.setValue(nuevo.getValue());
      actual.setRight(delete(actual.getRight(), nuevo.getValue()));

    }

    return actual;
  }

  private TreeNode getMinNode(TreeNode start) {
    if (start.getLeft() == null) {
      return start;
    }

    return getMinNode(start.getLeft());
  }

  private TreeNode getMaxNode(TreeNode start) {
    if (start.getRight() == null) {
      return start;
    }

    return getMaxNode(start.getRight());
  }

  public int getHeight() {
    return getHeight(root) - 1;
  }

  private int getHeight(TreeNode actual) {
    int sumLeft = 1, sumRight = 1;

    if (actual.getLeft() != null) {
      sumLeft += getHeight(actual.getLeft());
    }
    if (actual.getRight() != null) {
      sumRight += getHeight(actual.getRight());
    }

    return Math.max(sumLeft, sumRight);
  }

  public Integer getMaxElem() {
    return getMaxNode(root).getValue();
  }

  public void printPreOrder(){
    printPreOrder(root);
  }

  private void printPreOrder(TreeNode actual){
    if (actual == null) {
      return;
    }

    System.out.println(actual + " ");
    printPreOrder(actual.getLeft());
    printPreOrder(actual.getRight());
  }

  public void printPosOrder(){
    printPosOrder(root);
  }

  private void printPosOrder(TreeNode actual){
    if (actual == null) {
      return;
    }

    printPosOrder(actual.getLeft());
    printPosOrder(actual.getRight());
    System.out.println(actual + " ");
  }

  public void printInOrder(){
    printInOrder(root);
  }

  private void printInOrder(TreeNode actual){
    if (actual == null) {
      return;
    }

    printInOrder(actual.getLeft());
    System.out.println(actual + " ");
    printInOrder(actual.getRight());
  }


  public ArrayList<Integer> getFrontera(){
    ArrayList<Integer> res = new ArrayList<Integer>();

    getFrontera(root, res);


    return res;
  }

  private void getFrontera(TreeNode actual, ArrayList<Integer> acc){
    if (actual.getRight() == null && actual.getLeft() == null) {
      acc.add(actual.getValue());
      return;
    }

    getFrontera(actual.getLeft(), acc);
    getFrontera(actual.getRight(), acc);
  }


  public ArrayList<Integer> getLongestBranch(){
    return getLongestBranch(root);
  }

  private ArrayList<Integer> getLongestBranch(TreeNode actual){

    if (actual == null) {
      return new ArrayList<Integer>();
    }

    ArrayList<Integer> leftSide = getLongestBranch(actual.getLeft());
    ArrayList<Integer> rightSide = getLongestBranch(actual.getRight());

    if (leftSide.size() > rightSide.size()) {
      leftSide.add(0, actual.getValue());
      return leftSide;
    }else{
      rightSide.add(0, actual.getValue());
      return rightSide;
    }

    



  }


  public ArrayList<Integer> getElemAtLevel(int level){
    ArrayList<Integer> res = new ArrayList<Integer>();

    res.addAll(getElemAtLevel(root, level));

    return res;

    
  }

  private ArrayList<Integer> getElemAtLevel(TreeNode actual, int level){

    ArrayList<Integer> res = new ArrayList<Integer>();

    if (actual == null) {
      return res;
    }

    if(level == 0){

      res.add(actual.getValue());

      return res;
    }

    res.addAll(getElemAtLevel(actual.getRight(), level - 1));
    res.addAll(getElemAtLevel(actual.getLeft(), level - 1));

    return res;



  }


  public int getTotalSum(){
    return getTotalSum(root);
  }

  private int getTotalSum(TreeNode actual){
    if (actual == null) {
      return 0;
    }

    return getTotalSum(actual.getRight()) + getTotalSum(actual.getLeft()) + actual.getValue();
  }

  public ArrayList<Integer> getLeafsGreaterThan(Integer K){
    ArrayList<Integer> res = new ArrayList<Integer>();
    res.addAll(getLeafsGreaterThan(root, K));
    return res;
  }
  
  private ArrayList<Integer> getLeafsGreaterThan(TreeNode actual, Integer K){
    ArrayList<Integer> res = new ArrayList<Integer>();

    if (actual == null) {
      return res;
    }

    if (actual.getRight() == null && actual.getLeft() == null && actual.getValue() > K) {
      res.add(actual.getValue());

      return res;
    }

    res.addAll(getLeafsGreaterThan(actual.getLeft(), K));
    res.addAll(getLeafsGreaterThan(actual.getRight(), K));

    return res;
  }



  @Override
  public String toString() {
      if (root == null) return "Árbol vacío";
      return buildTreeString(root, "", false);
  }
  
  private String buildTreeString(TreeNode nodo, String prefix, boolean isTail) {
      if (nodo == null) return "";
  
      StringBuilder builder = new StringBuilder();
  
      if (nodo.getRight() != null) {
          builder.append(buildTreeString(nodo.getRight(), prefix + (isTail ? "│   " : "    "), false));
      }
  
      builder.append(prefix).append(isTail ? "└── " : "┌── ").append(nodo.getValue()).append("\n");
  
      if (nodo.getLeft() != null) {
          builder.append(buildTreeString(nodo.getLeft(), prefix + (isTail ? "    " : "│   "), true));
      }
  
      return builder.toString();
  }
  

}