import java.io.*;
import java.util.*;

/**
 * 방문길이 : https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */
public class Lv02_방문길이 {

  // 죄표 결정을 위한 해시맵 선언
  private static final HashMap<Character, int[]> location = new HashMap<>();

  private static void initLocation() {
    location.put('U', new int[]{0, 1});
    location.put('D', new int[]{0, -1});
    location.put('L', new int[]{-1, 0});
    location.put('R', new int[]{1, 0});
  }

  private boolean isValidMove(int nx, int ny) {
    return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
  }

  public int solution(String dirs) {
    // 1. 좌표 이동 해시맵 초기화
    initLocation();

    // 2. 캐릭터 현재 위치 & 경로를 저장할 해시셋 초기화
    int x = 5, y = 5;
    HashSet<String> answer = new HashSet<>();

    // 3. 캐릭터 이동 (이동 경로 저장)
    for (int i = 0; i < dirs.length(); i++) {
      int[] offset = location.get(dirs.charAt(i));
      int nx = x + offset[0];
      int ny = y + offset[1];
      // 3-1. 벗어난 좌표는 무시
      if(!isValidMove(nx, ny)) continue;
      // 3-2. A에서 B로 간 경우, B에서 A로 간 경우 모두 추가 (총 경로의 개수는 방향성이 없음)
      answer.add(x + " " + y + " " + nx + " " + ny);
      answer.add(nx + " " + ny + " " + x + " " + y);

      // 4. 좌표 이동 업데이트
      x = nx;
      y = ny;
    }
    return answer.size() / 2;
  }

  public static void main(String[] args) throws IOException {
    // 입력예시 :
    // ULURRDLLU
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Lv02_방문길이 main = new Lv02_방문길이();
    System.out.println("result = " + main.solution(str));
    // 결과 : 7

  }
}

