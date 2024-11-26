package _01주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기04 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int n = Integer.parseInt(stringTokenizer.nextToken());
    int m = Integer.parseInt(stringTokenizer.nextToken());

    // 구간의 합을 저장할 배열
    int[] arr = new int[n + 1];
    stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    // 첫번째 숫자 저장
    arr[1] = Integer.parseInt(stringTokenizer.nextToken());
    // 누적된 합을 저장
    for (int i = 2; i <= n; i++) {
      arr[i] = arr[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
    }

    System.out.println();
    System.out.println("arr = " + Arrays.toString(arr));

    // m 만큼 입력 받기
    for (int i = 0; i < m; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int start = Integer.parseInt(stringTokenizer.nextToken());
      int end = Integer.parseInt(stringTokenizer.nextToken());
      System.out.println(arr[end] - arr[start - 1]);
    }
    System.out.println();


  }
}
