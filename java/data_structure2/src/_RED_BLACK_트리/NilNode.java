package _RED_BLACK_트리;

public class NilNode extends BinaryTree {

  private boolean color;

  public NilNode() {
    super(0);
    this.color = BLACK; // NilNode는 검은색
  }
}
