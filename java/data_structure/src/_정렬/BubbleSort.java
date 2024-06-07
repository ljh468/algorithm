package _정렬;

import java.util.Arrays;

/**
 * Bubble Sort(버블 정렬)
 * 앞에 있는 숫자와 옆에 있는 숫자를 비교해서 자리를 바꾸는 알고리즘
 * - 앞에서부터 시작해서 맨 오른쪽부터 가장 큰 값을 채워나가는 방법
 * - 정렬이 완료된 마지막 요소는 제외하고 다시 시작 (하나만 남을때 까지)
 * - 이해와 구현이 간단함, 그러나 속도가 느림
 *
 * - 시간 복잡도
 *   - 1사이클이 돌때마다 정렬할 원소가 하나씩 줄어듬
 *   - 등차수열의 합으로 볼 수 있음 ex: (n - 1) + (n - 2) + (n - 3) ... + 2 + 1
 *   - 이중 for문이 동작하기때문에 O(n^2)의 시간 (느림)
 */
public class BubbleSort {

  void bubbleSort(int[] arr) {
    // 사이클 - 자리교체는 (배열의 갯수 - 1) 번 수행함
    for (int i = 0; i < arr.length - 1; i++) {
      // 횟수 - 정렬이 된 원소의 이전 원소보다 하나 이전의 원소까지 순회
      // 시작점이 (arr.length-i-1)번 임
      for (int j = 0; j < (arr.length - i - 1); j++) {
        // 앞의 데이터가 뒤에 데이터보다 더 크다면?
        if(arr[j] > arr[j + 1]) {
          // 데이터 자리변경
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 4};
    System.out.println("정렬 전 - arr = " + Arrays.toString(arr));
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.bubbleSort(arr);

    // 정렬 후 - arr = [1, 2, 3, 4]
    System.out.println("정렬 후 - arr = " + Arrays.toString(arr));
  }

}
