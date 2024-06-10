package _정렬;

import java.util.Arrays;

/**
 * Insertion Sort (삽입정렬)
 * 정렬되지 않은 영역에서 데이터를 하나씩 꺼내서
 * 정렬된 영역 내 적절한 위치에 "삽입"해서 정렬하는 알고리즘
 *
 * - 삽입하려는 데이터를 정렬된 영역의 원소를 역순으로 순회하면서 비교
 * - 이해와 구현이 간단함, 그러나 속도가 느림
 *
 * 시간 복잡도
 * - 이중 for문이 동작하기때문에 O(n^2)의 시간 (느림)
 */
public class InsertionSort {

  void insertionSort(int[] arr) {
    // 0번째 인덱스는 정렬되었다고 가정하고, i인덱스에 해당하는 원소는 정렬되지 않은 영역의 첫번째 데이터임
    for(int i = 1; i < arr.length; i++) {
      int insertingData = arr[i];

      // 정렬된 영역의 맨 뒤부터 첫번째 원소까지 역순으로 순회하면서, 정렬될 원소의 삽입위치를 찾는 부분
      // 삽입위치를 기억하기 위한 변수
      int j;

      // j는 정렬된 영역의 맨 뒤 인덱스로 설정
      for(j = i - 1; j >= 0; j--) {
        // 현재 순회하는 인덱스의 원소가 삽입할 원소보다 크다면? 오른쪽 인덱스에 덮어씌움
        if (arr[j] > insertingData) {
          arr[j + 1] = arr[j];
        } else {
          // 삽입할 원소보다 작은 원소의 자리를 찾았으니 for문을 종료
          break;
        }
      }

      // 삽입할 원소보다 작은 원소의 인덱스는 j에 기록됨, j+1이 삽입될 위치
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
