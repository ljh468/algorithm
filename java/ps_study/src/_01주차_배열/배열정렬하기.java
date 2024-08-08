package _01주차_배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 배열정렬하기 {
  /**
   * 배열 정렬하기
   * - 정수 배열을 정렬해서 반환하는 solution() 함수를 완성
   * - 정수 배열의 길이는 2이상 10^5이하
   * - 정수 배열의 각 데이터 값은 -100,000 이상 ~ 100,000 이하
   */
  private int[] sortAsc(int[] arr) {
    Arrays.sort(arr); // 오름차순으로 정렬
    return arr;
  }

  private int[] sortDesc(int[] arr) {
    Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(integerArray, Collections.reverseOrder());
    return Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) throws IOException {
    // 입력예시 :
    // 1, -5, 2, 4, 3
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("정수 배열을 입력하세요 (공백으로 구분): ");
    int[] numbers = Arrays.stream(br.readLine().split(", "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

    배열정렬하기 main = new 배열정렬하기();

    // 오름차순 정렬 결과 : [-5, 1, 2, 3, 4]
    int[] ascendingResult = main.sortAsc(numbers.clone());
    System.out.println("오름차순 정렬 결과: " + Arrays.toString(ascendingResult));

    // 내림차순 정렬 결과 : [4, 3, 2, 1, -5]
    int[] descendingResult = main.sortDesc(numbers.clone());
    System.out.println("내림차순 정렬 결과: " + Arrays.toString(descendingResult));
  }
}
