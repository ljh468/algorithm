import javax.imageio.ImageWriteParam;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if(divisor_even(i)){
                answer += i;
            } else{
                answer -= i;
            }
        }
        return answer;
    }
    private boolean divisor_even(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        return cnt % 2 == 0;
    }

    /**
     * 제곱수의 약수의 개수는 홀수이다.
     */
    public int solution2(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            // 제곱수인 경우 약수의 개수는 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            // 제곱수가 아닌 경우 약수의 개수는 짝수
            else answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        약수의개수와덧셈 sol = new 약수의개수와덧셈();
        int left = 24;
        int right = 27;
        System.out.println(sol.solution(left, right));
        System.out.println(sol.solution2(left, right));
    }
}
