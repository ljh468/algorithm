import java.util.*;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. Set을 만든다. (lostSet, reserveSet)
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for(int r : reserve)
            resSet.add(r);
        for (int l : lost) {
            if (resSet.contains(l)) {
                resSet.remove(l);
            } else {
                lostSet.add(l);
            }
        }
        // 2. Reserve에서 하나씩 꺼내서 lostSet에 줄 수 있는 사람을 찾아서 준다.
        for(int re : resSet)
            // 앞자리 학생이 필요한지 확인
            if (lostSet.contains(re-1)) {
                lostSet.remove(re - 1);
            }
            // 뒷자리 학생이 필요한지 확인
            else if (lostSet.contains(re + 1)) {
                lostSet.remove(re + 1);
            }

        // 3. 전체인원에서 lostSet의 인원을 빼서 체육복을 갖고 있는 사람 수를 반환
        return n - lostSet.size();
    }
    public int solution2(int n, int[] lost, int[] reserve) {
        // 1. student 배열 생성
        int[] student = new int[n + 2];
        int answer = 0;

        // 2. reserve, lost 정보 반영
        for(int l : lost)
            student[l]--;
        for(int r : reserve)
            student[r]++;

        // 3. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        for (int i = 1; i <= n; i++) {
            if (student[i] == 1) {
                if (student[i - 1] == -1) {
                    student[i]--;
                    student[i-1]++;
                } else if (student[i + 1] == -1) {
                    student[i]--;
                    student[i+1]++;
                }
            }
        }
        // 4. 체육복을 갖고 있는 학생수를 계산한다.
        for (int i = 1; i <= n; i++) {
            if(student[i] >= 0)
                answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        체육복 sol = new 체육복();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(n, lost, reserve));
        System.out.println(sol.solution2(n, lost, reserve));
    }
}
