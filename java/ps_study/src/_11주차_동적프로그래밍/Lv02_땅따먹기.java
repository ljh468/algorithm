package _11주차_동적프로그래밍;

public class Lv02_땅따먹기 {

  public static int solution(int[][] land) {
    // 1. 행의 개수
    int n = land.length;

    // 2. 각 행에 대해 반복
    for (int i = 0; i < n - 1; i++) { // 0 -> 1
      // 1번째 행의 0번째 열은 0번째 행의 1, 2, 3 열 중 최대값을 더함
      // 1번째 행의 1번째 열은 0번째 행의 0, 2, 3 열 중 최대값을 더함 (같은 열을 연속해서 밟을 수 없기 때문)
      land[i + 1][0] += Math.max(Math.max(land[i][1], land[i][2]), land[i][3]);
      land[i + 1][1] += Math.max(Math.max(land[i][0], land[i][2]), land[i][3]);
      land[i + 1][2] += Math.max(Math.max(land[i][0], land[i][1]), land[i][3]);
      land[i + 1][3] += Math.max(Math.max(land[i][0], land[i][1]), land[i][2]);
    }

    // 3. 마지막 행의 열들 중 최대값을 반환
    return Math.max(Math.max(land[n - 1][0], land[n - 1][1]),
                    Math.max(land[n - 1][2], land[n - 1][3])
    );
  }

  public static void main(String[] args) {
    int land[][] = {
        {1, 2, 3, 5},
        {5, 6, 7, 8},
        {4, 3, 2, 1}
    };

    int result = solution(land);
    System.out.println("result = " + result);
  }
}
