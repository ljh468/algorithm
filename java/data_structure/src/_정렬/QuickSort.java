package _정렬;

import java.util.Arrays;

/**
 * QuickSort (퀵정렬)
 * 배열의 숫자중 하나를 피벗으로 설정하고, 왼쪽은 피벗보다 큰값을 오른쪽은 피벗보다 작은값을 찾으면 교환
 * 왼쪽과 오른쪽의 포인트가 교차하면 피벗과 오른쪽 포인트의 값과 교환하여 피벗값을 정렬하는 방식의 알고리즘
 * - 분할정복 알고리즘에 속함 (재귀)
 * - 이해와 구현이 어려움, 그러나 속도가 빠름
 * - 더 적은 메모리와, 더 적은 비교를 사용하기때문에 병합정렬보다 좋은 알고리즘으로 평가됨
 * <p>
 * <p>
 * 시간 복잡도
 * 퀵정렬은 피벗을 기준으로 배열을 반으로 나눔 (데이터 한개가 정렬될때까지 나누기때문에 O(logN))
 * 이렇게 나눠진 단계를 배열의 원소 수 n만큼 진행해야 하기때문에 O(NlogN), 최대 O(n^2)
 */
public class QuickSort {

  //  void quickSort(int[] arr, int left, int right) {
  //    // 기저조건
  //    if (left < right) {
  //      // 정렬하기 위한 divide 함수 호출
  //      int pivotIndex = divide(arr, left, right);
  //
  //      // 피벗의 왼쪽 영역 정렬
  //      quickSort(arr, left, pivotIndex - 1);
  //
  //      // 피벗의 오른쪽 영역 정렬
  //      quickSort(arr, pivotIndex + 1, right);
  //    }
  //  }
  //
  //  int divide(int[] arr, int left, int right) {
  //    int pivot = arr[left];
  //    int leftStartIndex = left + 1;
  //    int rightStartIndex = right;
  //
  //    while (leftStartIndex <= rightStartIndex) {
  //      // 왼쪽 포인트가 피벗보다 큰 값을 만날 때까지 오른쪽으로 이동
  //      while (leftStartIndex <= right && arr[leftStartIndex] <= pivot) {
  //        leftStartIndex++;
  //      }
  //
  //      // 오른쪽 포인트가 피벗보다 작은 값을 만날 때까지 왼쪽으로 이동
  //      while (rightStartIndex >= (left + 1) && arr[rightStartIndex] >= pivot) {
  //        rightStartIndex--;
  //      }
  //
  //      // 서로 교차하지 않으면 값의 위치를 변경
  //      if (leftStartIndex < rightStartIndex) {
  //        swap(arr, leftStartIndex, rightStartIndex);
  //      }
  //    }
  //
  //    // while문이 끝나면 왼쪽 포인트와 오른쪽 포인트는 교차하게 됨
  //    swap(arr, left, rightStartIndex);
  //    return rightStartIndex; // 정렬된 피벗의 인덱스를 반환
  //  }

  void quickSort(int[] arr, int left, int right) {
    // 기저조건
    if (left < right) {
      // 피벗
      int pivotIndex = divide(arr, left, right);
      // 피벗 왼쪽 배열 정렬
      quickSort(arr, left, pivotIndex - 1);
      // 피벗 오른쪽 배열 정렬
      quickSort(arr, pivotIndex + 1, right);
    }
  }

  int divide(int[] arr, int left, int right) {
    int pivot = arr[left];
    int leftStartIndex = left + 1;
    int rightStartIndex = right;

    // leftStartIndex가 rightStartIndex를 넘어가지 않을때까지 반복
    while (leftStartIndex <= rightStartIndex) {
      // leftStartIndex가 범위를 넘어가지 않고, pivot보다 큰값을 찾을때까지 이동
      while (leftStartIndex <= right && arr[leftStartIndex] <= pivot) {
        leftStartIndex++;
      }
      // rightStartIndex가 범위를 넘어가지 않고, pivot보다 작은값을 찾을때까지 이동
      while (rightStartIndex >= (left + 1) && arr[rightStartIndex] >= pivot) {
        rightStartIndex--;
      }
      // leftStartIndex가 rightStartIndex를 넘어가지않았다면, 서로 값을 교환
      if (leftStartIndex < rightStartIndex) {
        swap(arr, leftStartIndex, rightStartIndex);
      }
    }

    // leftStartIndex가 rightStartIndex를 넘어가서, 포인트가 서로 교차되었다면 pivot과 rightStartIndex를 교환
    swap(arr, left, rightStartIndex);
    return rightStartIndex;
  }

  void swap(int[] arr, int index1, int index2) {
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {5, 3, 7, 2, 6, 4, 9, 1, 8};

    // 정렬 전 - arr = [5, 3, 7, 2, 6, 4, 9, 1, 8]
    System.out.println("정렬 전 - arr = " + Arrays.toString(arr));

    QuickSort quickSort = new QuickSort();
    quickSort.quickSort(arr, 0, arr.length - 1);

    // 정렬 후 - arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    System.out.println("정렬 후 - arr = " + Arrays.toString(arr));
  }
}
