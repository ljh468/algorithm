public class 약수의합 {
    public int solution(int n) {
        int answer = 0;
        // n의 절반은 n*2 그러므로 그위의 값은 자기자신을 제외하고 약수가 아님
        for (int i = 1; i <= n/2 ; i++) {
            if(n % i == 0) answer+= i;
        }
        return answer + n;
    }

    public static void main(String[] args) {
        약수의합 sol = new 약수의합();
        int n = 12;
        System.out.println(sol.solution(n));
    }
}
