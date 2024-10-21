package _정렬;

import java.util.Arrays;

/**
 * MergeSort (병합정렬)
 * 정렬하려고 하는 배열을 잘게 쪼갠다음, 순서에 맞게 재배열하는 알고리즘 (재귀)
 * - 이해와 구현이 어려움, 그러나 속도가 빠름
 * <p>
 * divide and conquer (분할정복)
 * 해결하기 힘든 문제가 발생한다면, 이걸 한 번에 해결하려고 하지 말고
 * 해결하기 쉬울 정도로 문제를 쪼갠 다음 하나씩 해결하는 방법
 * <p>
 * <p>
 * 시간 복잡도
 * - 병합 정렬에서 성능을 평가하는 부분은 merge함수내 흩어진 배열을 합치는 부분
 * - 하나의 데이터와 하나의 데이터가 두개로 합쳐질 때 비교 연산을 2번 수행함
 * - 각 merge 단계를 거칠때마다 영역의 수가 반으로 줄기 때문에, O(logN)
 * - 분할된 배열을 병합할 때는 n개의 데이터를 n번 비교하므로 n * logN 되어 O(NlogN)
 */
public class MergeSort {

  // leftIndex, rightIndex는 재귀를 호출할때 필요한 매개변수
  void mergeSort(int[] arr, int leftIndex, int rightIndex) {

    // 기저 조건: 왼쪽 인덱스가 오른쪽 인덱스보다 크거나 같으면 재귀를 종료
    // 재귀를 이용해 원소가 1개일때까지 분할하기 위함
    if (leftIndex >= rightIndex) {
      return;
    }

    // 중간 인덱스를 계산 (배열을 두 부분으로 나누기 위함)
    int midIndex = (leftIndex + rightIndex) / 2;

    // 왼쪽 하위 배열을 정렬
    mergeSort(arr, leftIndex, midIndex);

    // 오른쪽 하위 배열을 정렬
    mergeSort(arr, midIndex + 1, rightIndex);

    // 정렬된 두 하위 배열을 병합
    merge(arr, leftIndex, midIndex, rightIndex);
  }

  void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {
    int tempAreaIndex = leftIndex;
    int leftAreaIndex = leftIndex;
    int rightAreaIndex = midIndex + 1;

    // 병합에 사용할 임시 배열 생성
    int[] tempArr = new int[rightIndex + 1];

    // 어느 한쪽의 배열의 정렬이 끝날때까지 반복
    while (leftAreaIndex <= midIndex && rightAreaIndex <= rightIndex) {
      // 왼쪽이 작다면? 임시배열(tempArr)에 추가하고, leftAreaIndex + 1, tempAreaIndex + 1 해줌
      if (arr[leftAreaIndex] <= arr[rightAreaIndex]) {
        tempArr[tempAreaIndex++] = arr[leftAreaIndex++];
      } else { // 오른쪽이 작다면? 임시배열(tempArr)에 추가하고, rightAreaIndex + 1, tempAreaIndex + 1
        tempArr[tempAreaIndex++] = arr[rightAreaIndex++];
      }
    }

    // 왼쪽의 배열이 모두 정렬 되었으면, 나머지 정렬되지 않은 오른쪽 배열의 원소를 추가해줌
    if (leftAreaIndex > midIndex) {
      for (int i = rightAreaIndex; i <= rightIndex; i++) {
        tempArr[tempAreaIndex++] = arr[i];
      }
    } else { // 오른쪽 배열이 모두 정렬되었으면, 나머지 정렬되지 않은 왼쪽 배열의 원소를 추가해줌
      for (int i = leftAreaIndex; i <= midIndex; i++) {
        tempArr[tempAreaIndex++] = arr[i];
      }
    }

    // 정렬해준 tempArr를 원본 arr에 채워줌 (leftIndex -> rightIndex까지)
    for (int i = leftIndex; i <= rightIndex; i++) {
      arr[i] = tempArr[i];
    }

  }

  public static void main(String[] args) {
    int[] arr = {3, 5, 2, 4, 1, 7, 8, 6};

    // 정렬 전 - arr = [3, 5, 2, 4, 1, 7, 8, 6]
    System.out.println("#### 정렬 전 - arr = " + Arrays.toString(arr) + " ####");

    MergeSort mergeSort = new MergeSort();
    mergeSort.mergeSort(arr, 0, arr.length - 1);

    // 정렬 후 - arr = [1, 2, 3, 4, 5, 6, 7, 8]
    System.out.println("#### 정렬 후 - arr = " + Arrays.toString(arr) + " ####");
  }
}