public class UnorderedTreeInteger extends UnorderedTree<Integer>{
  public void fillNullishNodes(){
    fillNullishNodes(root);
  }

  private void fillNullishNodes(TreeNode<Integer> actual){

    if (actual == null) {
      return;
    }

    if (actual.getLeft() == null && actual.getRight() == null) {
      return;
    }

    fillNullishNodes(actual.getLeft());
    fillNullishNodes(actual.getRight());

    int n1 = 0;
    int n2 = 0;

    if (actual.getRight() != null) {
      n1 = actual.getRight().getValue();
    }
    if (actual.getLeft() != null) {
      n2 = actual.getLeft().getValue();
    }


    actual.setValue(n1 - n2);
  }
}
