import java.util.Arrays;

public class 소수찾기 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i))
                answer++;
        }
        return answer;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        소수찾기 sol = new 소수찾기();
        int n = 10;
        System.out.println(sol.solution(n));
    }
}
