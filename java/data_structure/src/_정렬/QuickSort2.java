package _정렬;

import java.util.Arrays;

public class QuickSort2 {

  public static void main(String[] args) {
    User[] arr = {
        new User("홍길동", 5),
        new User("임꺽정", 4),
        new User("이순신", 3),
        new User("나", 1),
        new User("짱구", 5)
    };

    System.out.println("===== 정렬 전 =====");
    System.out.println(Arrays.toString(arr));

    // 퀵정렬 실행
    quickSort(arr, 0, arr.length - 1);

    // 첫 번째 나의 데이터의 출석수 변경
    arr[0].count = 5;

    System.out.println("===== 정렬 후 =====");
    System.out.println(Arrays.toString(arr));
  }

  // 퀵정렬 함수
  static void quickSort(User[] arr, int left, int right) {
    // 기저조건
    if (left >= right) {
      return;
    }

    int pivotIndex = divide(arr, left, right);
    quickSort(arr, left, pivotIndex - 1);
    quickSort(arr, pivotIndex + 1, right);
  }

  // 배열을 나누고 피벗의 위치를 반환하는 함수
  static int divide(User[] arr, int left, int right) {
    int pivot = arr[left].count; // 피벗은 첫 번째 원소의 count 값
    int leftStartIndex = left + 1;
    int rightStartIndex = right;

    while (leftStartIndex <= rightStartIndex) {
      // 피벗보다 큰 값을 찾을 때까지 왼쪽에서 오른쪽으로 이동
      while (leftStartIndex <= right && arr[leftStartIndex].count <= pivot) {
        leftStartIndex++;
      }

      // 피벗보다 작은 값을 찾을 때까지 오른쪽에서 왼쪽으로 이동
      while (rightStartIndex >= left + 1 && arr[rightStartIndex].count >= pivot) {
        rightStartIndex--;
      }

      // 인덱스가 교차하지 않았으면 값 교환
      if (leftStartIndex < rightStartIndex) {
        swap(arr, leftStartIndex, rightStartIndex);
      }
    }

    // 피벗과 rightStartIndex 교환
    swap(arr, left, rightStartIndex);

    return rightStartIndex;
  }

  // 두 원소의 값을 교환하는 함수
  static void swap(User[] arr, int index1, int index2) {
    User temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

}

class User {
  String name;
  int count;

  User(String name, int count) {
    this.name = name;
    this.count = count;
  }

  @Override
  public String toString() {
    return "{name: '" + name + "', count: " + count + "}";
  }
}
