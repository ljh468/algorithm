import java.util.Arrays;

public class 최대공약수와최소공배수 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        for (int i = 1; i <= Math.min(n, m); i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
                answer[1] = n * m / answer[0];
            }
        }
        return answer;
    }
    // 유클리드 호제법
    public int[] solution2(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n,m);
        answer[1] = (n*m)/answer[0];
        return answer;
    }
    public int gcd(int n, int m){
        if(n%m == 0) return m;
        return gcd(m, n%m);
    }

    public static void main(String[] args) {
        최대공약수와최소공배수 sol = new 최대공약수와최소공배수();
        int n = 3;
        int m = 12;
        System.out.println(Arrays.toString(sol.solution(n, m)));
        System.out.println(Arrays.toString(sol.solution2(n, m)));
    }
}
