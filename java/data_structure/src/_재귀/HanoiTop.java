package _재귀;

public class HanoiTop {

  void hanoi(int count, String from, String to, String temp){
    if(count == 0) return;
    hanoi(count - 1, from, temp, to);
    System.out.printf("원반 %d를 %s에서 %s로 이동\n", count, from, to);
    hanoi(count - 1, temp, to, from);
  }

  public static void main(String[] args) {
    HanoiTop hanoiTop = new HanoiTop();
    hanoiTop.hanoi(3, "A", "C", "B");
  }

}
