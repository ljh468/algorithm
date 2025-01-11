package _10주차_정렬;

import java.util.Arrays;

public class _삽입정렬 {

  static void insertingSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int insertingData = arr[i];

      int j = i - 1;
      while (j >= 0 && arr[j] > insertingData) {
        arr[j + 1] = arr[j];
        j--;
      }

      arr[j + 1] = insertingData;
    }
  }

  public static void main(String[] args) {
    int[] arr = {4, 1, 5, 3, 6, 2};
    System.out.println("#### 정렬 전 - arr = " + Arrays.toString(arr) + " ####");
    insertingSort(arr);
    System.out.println("#### 정렬 후 - arr = " + Arrays.toString(arr) + " ####");
  }
}
