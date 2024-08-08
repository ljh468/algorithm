import java.io.*;
import java.util.*;

/**
 * 모의고사 : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class Lv01_모의고사 {

  public int[] solution(int[] answers) {
    int[] one = {1, 2, 3, 4, 5};
    int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    int[] score = {0, 0, 0};

    for (int i = 0; i < answers.length; i++) {
      if (one[i] % one.length == answers[i]) score[0]++;
      if (two[i] % one.length == answers[i]) score[1]++;
      if (three[i] % one.length == answers[i]) score[2]++;
    }

    int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

    int size = 0;
    for(int s : score) {
      if(maxScore == s) size++;
    }

    int[] results = new int[size];
    int index = 0;
    for(int i = 0; i < score.length; i++) {
      if(score[i] == maxScore) {
        results[index++] = i + 1;
      }
    }
    return results;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::valueOf).toArray();

    Lv01_모의고사 LV01_모의고사 = new Lv01_모의고사();
    System.out.println("result = " + Arrays.toString(LV01_모의고사.solution(arr)));;

  }
}
