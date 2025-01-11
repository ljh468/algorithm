package _10주차_정렬;

import java.util.Arrays;
import java.util.Collections;

// https://www.acmicpc.net/problem/2751
public class _수_정렬하기_연습02 {

  public static void main(String[] args) {
    int[] arr = {1, 2, 5, 4, 3};
    Integer[] integerArr = Arrays.stream(arr).boxed().toArray(len -> new Integer[len]);
    System.out.println("result = " + Arrays.toString(integerArr));
    int[] intArr = Arrays.stream(solution(integerArr)).mapToInt(num -> num.intValue()).toArray();
    System.out.println("result = " + Arrays.toString(intArr));

    String[] stringArr = {"a", "d", "b", "c"};
    System.out.println("result2 = " + Arrays.toString(stringArr));
    System.out.println("result2 = " + Arrays.toString(solution(stringArr)));
  }

  public static Integer[] solution(Integer[] arr) {
    Arrays.sort(arr, Collections.reverseOrder());
    return arr;
  }

  public static String[] solution(String[] arr) {
    Arrays.sort(arr, Collections.reverseOrder());
    return arr;
  }
}
