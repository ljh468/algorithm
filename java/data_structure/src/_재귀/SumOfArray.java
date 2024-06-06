package _재귀;

import java.util.Arrays;

public class SumOfArray {

  public int sumArray(int[] arr) {
    // 기저조건
    if (arr.length == 1) {
      return arr[0];
    }
    // 재귀적으로 새로운 배열의 합과 마지막 요소를 더하여 반환
    return sumArray(Arrays.copyOfRange(arr, 0, arr.length - 1)) + arr[arr.length - 1];
  }

  public static void main(String[] args) {
    SumOfArray sumOfArray = new SumOfArray();
    int[] arr = {1, 2, 3, 4, 5};
    int sum = sumOfArray.sumArray(arr);
    System.out.println(sum);
  }

}