package _12주차_그리디;

//https://school.programmers.co.kr/learn/courses/30/lessons/42860
public class Lv02_조이스틱 {

  public static int solution(String name) {
    int count = 0;
    // 1. 문자열 순회
    for (int i = 0; i < name.length(); i++) {
      // 1-1. 첫번째문자가 아니면 조작횟수 증가
      if(i > 0) count++;

      // 1-2 조이스틱을 오른쪽으로 이동하는게 더 빠른지 확인
      // 1-3. [찾을 문자 - A]가 13보다 크면 반대방향 조작 ((Z+1) - 찾을문자)
      // 1-4. [찾을 문자 - A]가 13보다 작거나 같으면 정방향 조작(찾을 문자 - A)
      char ch = name.charAt(i);
      if ((ch - 'A') <= 13) {
        count += ch - 'A';
      } else {
        count += ('Z' + 1) - ch;
      }

      // 최적 문자열 이동 횟수를 찾아야되는데?
      // 다음 문자에 A가오는지 찾기
      // 안나올때까지의 거리 찾기
      //
    }

    return count;
  }

  public static void main(String[] args) {
    String name1 = "JEROEN";
    System.out.println(name1 + " = " +  solution(name1)); // 56

    String name2 = "JAN";
    System.out.println(name2 + " = " + solution(name2)); // 23
  }
}
