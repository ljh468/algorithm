import java.io.*;
import java.util.*;

public class 배열제어하기 {
  /**
   * 배열제어하기
   * - 정수 배열을 하나 받아, 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution() 함수를 구현하세요.
   * - 제약조건
   * - 배열의 길이는 2이상 1000이하
   * - 각 배열의 데이터 값은 -100,000이상 100,000이하
   */

  public static int[] solution(int[] arr) {
    // 1. 중복 제거
    Integer[] numbers = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
    // 2. 내림차순 정렬
    Arrays.sort(numbers, Collections.reverseOrder());
    return Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("정수 배열을 입력하세요 (공백으로 구분): "); // 예시: 4, 2, 2, 1, 3, 4
    int[] numbers = Arrays.stream(br.readLine().split(", ")).mapToInt(Integer::valueOf).toArray();
    System.out.println(Arrays.toString(solution(numbers)));
  }
}
