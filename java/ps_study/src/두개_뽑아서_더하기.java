import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class 두개_뽑아서_더하기 {
  /**
   * 두개 뽑아서 더하기
   * - 주어진 정수 배열 numbers에서 서로 다른 인덱스에 있는 2개의 수를 뽑아 더해 만들 수 있는 모든 수를 배열에 오름차순으로 담아 반환하는 함수를 완성하시오.
   * - 제약조건 :
   * - numbers의 길이는 2이상 100이하
   * - numbers의 모든 수는 0이상 100이하
   */
  public static int[] solution(int[] numbers) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = i + 1; j < numbers.length; j++) {
        set.add(numbers[i] + numbers[j]);
      }
    }
    // hashSet 오름차순 정렬 & int[] 형태의 배열로 변환하여 전환
    return set.stream()
              .sorted()
              .mapToInt(Integer::intValue)
              .toArray();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 예시: 1, 2, 3, 4, 1
    int[] numbers = Arrays.stream(br.readLine().split(", ")).mapToInt(Integer::valueOf).toArray();
    System.out.println("solution(numbers) = " + Arrays.toString(solution(numbers)));
  }
}
