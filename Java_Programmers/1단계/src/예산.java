import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int n : d) {
            if(budget < n)
                break;
            budget -= n;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        예산 sol = new 예산();
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(sol.solution(d, budget));
    }
}
