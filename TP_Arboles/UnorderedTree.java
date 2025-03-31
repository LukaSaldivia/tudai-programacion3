public class UnorderedTree<T> {
  protected TreeNode<T> root, current, prev;

  public UnorderedTree() {
    root = new TreeNode<T>(null);
    current = root;
  }

  public UnorderedTree<T> setValue(T value) {
    current.setValue(value);
    return this;
  }

  public UnorderedTree<T> goLeft() {
    if (current.getLeft() == null) {
      current.setLeft(new TreeNode<T>(null));
    }
    prev = current;
    current = current.getLeft();
    return this;
  }

  public UnorderedTree<T> goRight() {
    if (current.getRight() == null) {
      current.setRight(new TreeNode<T>(null));
    }
    prev = current;
    current = current.getRight();
    return this;
  }

  public UnorderedTree<T> goRoot() {
    prev = current;
    current = root;
    return this;
  }

  public UnorderedTree<T> goPrev() {
    if (prev != null) {
      current = prev;
    }
    return this;
  }

  @Override
  public String toString() {
    if (root == null)
      return "Árbol vacío";
    return buildTreeString(root, "", false);
  }

  private String buildTreeString(TreeNode<T> nodo, String prefix, boolean isTail) {
    if (nodo == null)
      return "";

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
