package _정렬;

import java.util.Arrays;

/**
 * Selection Sort(선택 정렬)
 * 정렬되지 않은 배열의 첫번째 원소를 시작으로 마지막 원소까지 탐색하여
 * 가장 작은 값을 정렬되지 않은 첫번째 배열로 가져오는 알고리즘
 * - 앞에서부터 시작해서 맨 왼쪽부터 가장 작은 값을 채워나가는 방법
 * - 이해와 구현이 간단함, 그러나 속도가 느림
 *
 * 시간 복잡도
 * - 바깥쪽 for문이 실행될 수 록 안쪽 for문이 줄어드는 형태 (등차수열의 합)
 * - 이중 for문이 동작하기때문에 O(n^2)의 시간 (느림)
 */
public class SelectionSort {

  void selectionSort(int[] arr) {
    // 1 사이클의 순회는(배열의 갯수 - 1) 번 수행됨
    for(int i = 0; i < arr.length - 1; i++) {
      int minValueIndex = i;

      // 가장 작은 값을 탐색하기위해 순회
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minValueIndex]) {
          // 작은값 저장
          minValueIndex = j;
        }
      }

      // 자리 변경
      int temp = arr[i];
      arr[i] = arr[minValueIndex];
      arr[minValueIndex] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = {4, 2, 1, 3};

    // 정렬 전 - arr = [4, 2, 1, 3]
    System.out.println("정렬 전 - arr = " + Arrays.toString(arr));
    SelectionSort selectionSort = new SelectionSort();
    selectionSort.selectionSort(arr);

    // 정렬 후 - arr = [1, 2, 3, 4]
    System.out.println("정렬 후 - arr = " + Arrays.toString(arr));
  }
}
