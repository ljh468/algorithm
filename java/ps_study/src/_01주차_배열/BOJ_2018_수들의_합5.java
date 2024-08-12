package _01주차_배열;

public class BOJ_2018_수들의_합5 {

  // 시간복잡도 O(N) - 투포인터 활용
  public int solution1(int n) {
    int answer = 0;
    int sum = 0;

    // 2. L, R 포인터 초기화
    int lt = 0;
    int rt = 0;

    // 3. 수들의 합을 저장할 변수 선언 (시작점이 1이기때문에 초기값 1)
    while (rt <= n) {
      // 4-2. N을 넘어가지 않으면 R이동하고 합함
      if (sum < n) {
        rt++;
        sum += rt;
      }
      // 4-2. N을 넘어가면 sum에서 L을 빼주고, L이동
      else if (sum > n) {
        sum -= lt;
        lt++;
      }
      // 4-1. N과 같으면 경우의 수 증가
      else {
        answer++;
        rt++;
        sum += rt;
      }
    }
    return answer;
  }

  // 시간복잡도 O(N^2) - 이중반복문으로 풀면 시간초과
  public int solution2(int n) {
    int answer = 0;
    for (int start = 1; start <= n; start++) {
      int sum = 0;
      for (int end = start; end <= n; end++) {
        sum += end;
        // 수들의 합이 N과 같으면 경우의 수 +1 증가
        if (sum == n) {
          answer++;
          break;
        }
        // 수들의 합이 N보다 크면 안쪽 for문 종료
        else if (sum > n) {
          break;
        }
      }

    }
    return answer;
  }

  public static void main(String[] args) {
    BOJ_2018_수들의_합5 main = new BOJ_2018_수들의_합5();
    main.solution2(15);
    System.out.println("result = " + main.solution1(15));
    System.out.println("result = " + main.solution2(15));
  }
}
