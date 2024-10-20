package _정렬;

import java.util.Arrays;

/**
 * Insertion Sort (삽입정렬)
 * 정렬되지 않은 영역에서 데이터를 하나씩 꺼내서
 * 정렬된 영역 내 적절한 위치에 "삽입"해서 정렬하는 알고리즘
 * <p>
 * - 삽입하려는 데이터를 정렬된 영역의 원소를 역순으로 순회하면서 비교
 * - 이해와 구현이 간단함, 그러나 속도가 느림
 * <p>
 * 시간 복잡도
 * - 이중 for문이 동작하기때문에 O(n^2)의 시간 (느림)
 */
public class InsertionSort {

  void insertionSort(int[] arr) {
    // 0번째 인덱스는 정렬되었다고 가정하고, i인덱스에 해당하는 원소는 정렬되지 않은 영역의 첫번째 데이터임
    for (int i = 1; i < arr.length; i++) {
      int insertingData = arr[i];

      // j는 정렬된 영역의 마지막 원소 인덱스를 기억 (비교할 원소의 인덱스)
      int j = i - 1;

      // while문을 사용하여 정렬된 영역의 마지막 원소부터 역순으로 순회하여 삽입할 위치를 찾음
      // 비교할 데이터(j)가 삽입할 데이터 보다 작거나, 비교할 데이터가 없을때까지 반복
      while (j >= 0 && arr[j] > insertingData) {
        arr[j + 1] = arr[j];
        j--;
      }

      // 삽입할 위치를 찾았으면 그 자리에 삽입
      arr[j + 1] = insertingData;
    }

  }

  public static void main(String[] args) {
    int[] arr = {4, 1, 5, 3, 6, 2};

    // 정렬 전 - arr = [4, 1, 5, 3, 6, 2]
    System.out.println("정렬 전 - arr = " + Arrays.toString(arr));

    InsertionSort insertionSort = new InsertionSort();
    insertionSort.insertionSort(arr);

    // 정렬 후 - arr = [1, 2, 3, 4, 5, 6]
    System.out.println("정렬 후 - arr = " + Arrays.toString(arr));
  }
}
