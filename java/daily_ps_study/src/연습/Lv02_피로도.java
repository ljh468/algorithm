package 연습;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Lv02_피로도 {

  static boolean[] visited;

  static int answer;

  public static void main(String[] args) {
    int k = 80;
    int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
    System.out.println("result = " + solution(k, dungeons));
  }

  public static int solution(int k, int[][] dungeons) {
    visited = new boolean[dungeons.length];
    dfs(0, k, dungeons);
    return answer;
  }

  public static void dfs(int depth, int k, int[][] dungeons) {
    for (int i = 0; i < dungeons.length; i++) {
      // 방문하지 않았고, 최소 피로도에 충족하면 던전 방문
      if (!visited[i] && dungeons[i][0] <= k) {
        visited[i] = true; // 방문
        dfs(depth + 1, k - dungeons[i][1], dungeons); // 방문수 +1, 피로도 소모
        visited[i] = false; // 백트래킹
      }
    }
    // depth와 answer와 비교해서 최대값이 최대 던전 방문 횟수
    answer = Math.max(depth, answer);
  }
}
