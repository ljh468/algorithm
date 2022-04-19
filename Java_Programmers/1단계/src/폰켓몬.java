import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int cnt = nums.length / 2;
        HashSet<Integer> mon = new HashSet<>();
        for (int num : nums) {
            mon.add(num);
        }

        if (cnt < mon.size()) {
            return cnt;
        }
        return mon.size();
    }

    public static void main(String[] args) {
        폰켓몬 sol = new 폰켓몬();
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(sol.solution(nums));
    }
}
