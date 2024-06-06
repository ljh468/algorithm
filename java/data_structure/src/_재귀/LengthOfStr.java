package _재귀;

import java.util.Arrays;

public class LengthOfStr {

  public int strLength(String[] arr) {
    // 배열의 첫 번째 요소가 null이면 0을 반환
    if (arr.length == 0) {
      return 0;
    }
    // 재귀적으로 배열의 마지막 요소를 제외한 새로운 배열에 +1을 더하여 반환
    return strLength(Arrays.copyOfRange(arr, 0, arr.length - 1)) + 1;
  }

  public static void main(String[] args) {
    LengthOfStr lengthOfStr = new LengthOfStr();
    String[] arr = {"a", "b", "c", "d", "e"};
    int length = lengthOfStr.strLength(arr);
    System.out.println(length);  // 출력: 5
  }

}