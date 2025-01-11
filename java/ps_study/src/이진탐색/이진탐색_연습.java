package 이진탐색;

public class 이진탐색_연습 {

  private static int ANS = 17;

  public static void main(String[] args) {
    // 답으로 나올수 있는 최소값
    int left = 1;
    // 답으로 나올수 있는 최대값
    int right = 50;

    // left가 right보다 같거나 클때까지 반복
    while (left < right) {
      System.out.println("left = " + left + ", right = " + right);
      int mid = (left + right) / 2;
      // mid가 정답이 될 수 있니? (정답이 작거나 같아?)
      if (isPossible(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    System.out.println("answer = " + left);
  }

  // 정답이 될 수 있는지 확인하는 메서드
  public static boolean isPossible(int answer) {
    // 정답이 찾은 값보다 작거나 같으면 TRUE
    // 정답이 찾은 값보다 크면 FALSE
    return ANS <= answer;
  }

}
