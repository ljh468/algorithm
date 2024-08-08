package Lv01_연습문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수박수박수박수박수박수?
 * https://school.programmers.co.kr/learn/courses/30/lessons/12922
 */
public class Lv01_수박수박수박수 {

  public String solution(int n) {
    StringBuilder str = new StringBuilder();
    boolean flag = true;
    while (n > 0) {
      if (flag) {
        str.append("수");
        flag = false;
      } else {
        str.append("박");
        flag = true;
      }
      n--;
    }
    return str.toString();
  }

  public static void main(String[] args) throws IOException {
    Lv01_수박수박수박수 main = new Lv01_수박수박수박수();
    // 입력예시 :
    // 3
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    System.out.println("result = " + main.solution(num));
  }
}
