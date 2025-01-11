package 이진탐색;

import java.util.Arrays;

public class 이진탐색_연습2 {

  public static void main(String[] args) {
    int[] arr = {1, 5, 9, 14, 20};

    // 매개변수: [배열, 찾을 값]

    // 찾는 값이 있으면? 해당 위치(인덱스)를 반환
    System.out.println(Arrays.binarySearch(arr, 5));

    // 찾는 값이 없다면? 들어갈 위치를 알려줌

    // -1   -2   -3   -4   -5   -6
    //    0    1    2    3    4
    //    1    5    9    14   20
    System.out.println(Arrays.binarySearch(arr, 17));  // -5 리턴 (없다는 것을 나타내기위해 음수)

    // 찾는값이 없는지 확인
    int x = Arrays.binarySearch(arr, 17);
    if (x < 0) {
      System.out.println("배열 안에 없음"); // O(logN)만에 알 수 있음
      // 배열안에서 찾는 값보다 작은 수 중에 가장 큰값의 위치를 찾으려면?
      // 절대 값을 만들고, -2 하면 해당 값을 위치
      System.out.println("배열안에서 찾는 값보다 작은 수 중에 가장 큰값의 위치: " + arr[-x - 2]);

      // 배열안에서 찾는 값보다 큰 수 중에 가장 작은값의 위치를 찾으려면?
      // 절대 값을 만들고, -1 하면 해당 값을 위치
      System.out.println("배열안에서 찾는 값보다 큰 수 중에 가장 작은값의 위치: " + arr[-x - 1]);

      // # 인덱스가 넘어가지 않게 조심해야함 (배열의 가장 큰 수 보다 큰 값이면 에러)
    }

  }
}
