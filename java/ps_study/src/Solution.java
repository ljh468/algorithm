public class Solution {

  public static void main(String[] args) {
    int result = solution(1041);
    System.out.println("result = " + result);
  }

  public static int solution(int N) {
    String str = Integer.toString(N, 2);
    int maxGap = 0;
    int currentGap = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') {
        maxGap = Math.max(maxGap, currentGap);
        currentGap = 0;
      } else {
        currentGap++;
      }
    }
    return maxGap;
  }
}

