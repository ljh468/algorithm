package _Codility;

// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
public class MaxSliceSum {
  public static void main(String[] args) {
    int[] A = {3, 2, -6, 4, 0};
    System.out.println("result = " + solution(A));
  }

  /**
   * 코드의 핵심 아이디어<p>
   * 주어진 배열 A에서 연속된 부분 배열(subarray)의 합 중 최대값을 찾는 문제<p>
   * 이 문제는 카데인 알고리즘(Kadane's Algorithm)**을 사용하여 해결하며,<p>
   * 배열을 한 번 순회하면서 최대 합을 효율적으로 계산할 수 있음<p>
   */
  public static int solution(int[] A) {
    int slicing = A[0]; // slicing은 "현재까지 연속된 부분 배열"의 합
    int max = A[0]; // 전체에서 발견된 최대 합을 저장

    for (int i = 1; i < A.length; i++) {
      // 값을 갱신하며 최대 합을 찾아감 "(현재까지 연속된 부분 배열의 합 + 현재 값) vs 현재 값"을 비교
      // slicing을 갱신할 때, 현재 값(A[i])을 포함하거나 새로 시작할지 결정
      slicing = Math.max(A[i], slicing + A[i]);
      // 지금까지 발견된 최대 합이 가장 큰 값이면 갱신
      max = Math.max(max, slicing);
    }
    return max;
  }
}

/**
 * 코드 실행 과정<p>
 * 예시 입력: A = {3, 2, -6, 4, 0}<p>
 * <br>
 * 초기화<p>
 * slicing = A[0] = 3<p>
 * (첫 번째 값으로 초기화)<p>
 * max = A[0] = 3<p>
 * (최대값도 첫 번째 값으로 초기화)<p>
 * <br>
 * 1. i = 1<p>
 * 현재 값: A[1] = 2<p>
 * slicing 계산:<p>
 * slicing = Math.max(slicing + A[1], A[1])<p>
 * slicing = Math.max(3 + 2, 2) = 5<p>
 * max 갱신:<p>
 * max = Math.max(max, slicing)<p>
 * max = Math.max(3, 5) = 5<p>
 * <br>
 * 2. i = 2<p>
 * 현재 값: A[2] = -6<p>
 * slicing 계산:<p>
 * slicing = Math.max(slicing + A[2], A[2])<p>
 * slicing = Math.max(5 + (-6), -6) = -1<p>
 * max 갱신:<p>
 * max = Math.max(max, slicing)<p>
 * max = Math.max(5, -1) = 5<p>
 * <br>
 * 3. i = 3<p>
 * 현재 값: A[3] = 4<p>
 * slicing 계산:<p>
 * slicing = Math.max(slicing + A[3], A[3])<p>
 * slicing = Math.max(-1 + 4, 4) = 4<p>
 * max 갱신:<p>
 * max = Math.max(max, slicing)<p>
 * max = Math.max(5, 4) = 5<p>
 * <br>
 * 4. i = 4<p>
 * 현재 값: A[4] = 0<p>
 * slicing 계산:<p>
 * slicing = Math.max(slicing + A[4], A[4])<p>
 * slicing = Math.max(4 + 0, 0) = 4<p>
 * max 갱신:<p>
 * max = Math.max(max, slicing)<p>
 * max = Math.max(5, 4) = 5<p>
 */
