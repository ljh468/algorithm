import java.util.Arrays;

public class x만큼간격이있는n개의숫자 {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long sum = x;
        for (int i = 0; i < n; i++) {
            answer[i] = sum;
            sum += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        x만큼간격이있는n개의숫자 sol = new x만큼간격이있는n개의숫자();
        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(sol.solution(x, n)));
    }
}
