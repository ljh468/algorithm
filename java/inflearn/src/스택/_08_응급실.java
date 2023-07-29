package 스택;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 메디컬 병원 응급실에는 의사가 한 명밖에 없습니다.
 * 응급실은 환자가 도착한 순서대로 진료를 합니다. 하지만 위험도가 높은 환자는 빨리 응급조치를 의사가 해야 합니다.
 * 이런 문제를 보완하기 위해 응급실은 다음과 같은 방법으로 환자의 진료순서를 정합니다.
 * • 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 꺼냅니다.
 * • 나머지 대기 목록에서 꺼낸 환자 보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다. 그렇지 않으면 진료를 받습니다.
 * 즉 대기목록에 자기 보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조입니다.
 * 현재 N명의 환자가 대기목록에 있습니다.
 * N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하는 프로그램을 작성하세요.
 * 대기목록상의 M번째는 대기목록의 제일 처음 환자를 0번째로 간주하여 표현한 것입니다.
 *
 * 입력
 * 5 2
 * 60 50 70 80 90
 *
 * 출력
 * 3
 */
class Person{

  int id;
  int priority;

  public Person(int id, int priority) {
    this.id = id;
    this.priority = priority;
  }

}

public class _08_응급실 {

  public int solution1(int n, int m, int[] arr) {
    int answer = 0;

    // 1. 환자가 접수한 순서대로 큐에 저장
    Queue<Person> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      queue.offer(new Person(i, arr[i]));
    }

    // 2. 대기목록에서 진료할 환자를 꺼냄
    while (!queue.isEmpty()) {
      Person tmp = queue.poll();

      // 3. 꺼낸 환자보다 위험도가 높은 환자가 있는지 확인해서 있으면 꺼낸 환자를 목록의 맨뒤로 저장
      for (Person x : queue) {
        if (x.priority > tmp.priority) {
          queue.offer(tmp);
          tmp = null;
          break;
        }
      }

      // 4. 위험도가 높은 환자가 없으면 진료 가능
      if (tmp != null) {
        answer++;
        if (tmp.id == m) {
          return answer;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    _08_응급실 t = new _08_응급실();
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(t.solution1(n, m, arr));
  }
}
