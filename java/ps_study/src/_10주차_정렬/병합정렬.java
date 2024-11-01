package _10주차_정렬;

import java.util.Arrays;

public class 병합정렬 {

  static void mergeSort(int[] arr, int leftIndex, int rightIndex) {
    // 기저조건
    if (leftIndex >= rightIndex) return;

    int midIndex = (leftIndex + rightIndex) / 2;
    mergeSort(arr, leftIndex, midIndex);
    mergeSort(arr, midIndex + 1, rightIndex);
    merge(arr, leftIndex, midIndex, rightIndex);
  }

  static void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {
    int tempAreaIndex = leftIndex;
    int leftAreaIndex = leftIndex;
    int rightAreaIndex = midIndex + 1;

    int[] tempArr = new int[rightIndex + 1];

    while (leftAreaIndex <= midIndex && rightAreaIndex <= rightIndex) {
      if (arr[leftAreaIndex] <= arr[rightAreaIndex]) {
        tempArr[tempAreaIndex++] = arr[leftAreaIndex++];
      } else {
        tempArr[tempAreaIndex++] = arr[rightAreaIndex++];
      }
    }

    // 나머지 배열의 원소 채우기
    while (leftAreaIndex <= midIndex) {
      tempArr[tempAreaIndex++] = arr[leftAreaIndex++];
    }

    while (rightAreaIndex <= rightIndex) {
      tempArr[tempAreaIndex++] = arr[rightAreaIndex++];
    }

    for (int i = leftIndex; i <= rightIndex; i++) {
      arr[i] = tempArr[i];
    }
  }

  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 4, 1, 7, 8, 6};

    System.out.println("#### 정렬 전 - arr = " + Arrays.toString(arr) + " ####");
    mergeSort(arr, 0, arr.length - 1);
    System.out.println("#### 정렬 후 - arr = " + Arrays.toString(arr) + " ####");
  }
}
