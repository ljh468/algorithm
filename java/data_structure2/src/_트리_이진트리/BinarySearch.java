package _트리_이진트리;

/**
 * 이진탐색 알고리즘
 * - 선택마다 범위를 반으로 줄여서 탐색하는 알고리즘
 * - 정렬하려는 데이터는 정렬이 되어 있어야 함
 * <p>
 * 시간복잡도 : O(logN)
 */
public class BinarySearch {

  Integer binarySearch(int[] arr, int target, int start, int end) {
    // 기저조건
    if (start > end) {
      return null;
    }
    // 중간 인덱스를 찾음 (두 인덱스의 차이 / 2 + start)
    // 두 인덱스의 차이는 현재 탐색 범위의 길이 (end - start) / 2
    // 전체 배열의 기준으로 인덱스를 찾기위해 start를 더함 (end - start) / 2 + start
    int mid = (end - start) / 2 + start;

    // 타겟을 찾으면 return
    if (target == arr[mid]) {
      return mid;
    } else if (target > arr[mid]) { // 중간값보다 target이 크면 오른쪽 범위 재귀호출
      return binarySearch(arr, target, mid + 1, end);
    } else { // 중간값보다 target이 작으면 왼쪽 범위 재귀호출
      return binarySearch(arr, target, start, mid - 1);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int target = 3;
    BinarySearch binarySearch = new BinarySearch();
    Integer result = binarySearch.binarySearch(arr, target, 0, arr.length - 1);
    System.out.println("result index = " + result);
  }
}
