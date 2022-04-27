import java.util.HashSet;

public class 체육복_연습 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. Set을 만든다. (lostSet, resSet)
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        for (int res : reserve) {
            resSet.add(res);
        }
        for (int lo : lost) {
            if (resSet.contains(lo)) {
                resSet.remove(lo);
            } else{
                lostSet.add(lo);
            }
        }
        // 2. Reserve에서 하나씩 꺼내서 lostSet에 줄 수 있는 사람을 찾아서 준다.
        for (Integer r : resSet) {
            if(lostSet.contains(r-1)) lostSet.remove(r - 1);
            else if(lostSet.contains(r+1)) lostSet.remove(r + 1);
        }

        // 3. 전체인원에서 lostSet의 인원을 빼서 체육복을 갖고 있는 사람 수를 반환
        return n - lostSet.size();
    }
    public static void main(String[] args) {
        체육복_연습 sol = new 체육복_연습();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(n, lost, reserve));
    }
}
