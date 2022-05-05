import java.util.Arrays;

public class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String[] arr = String.valueOf(n).split("");
        for (String s : arr) {
            answer += Integer.valueOf(s);
        }
        return answer;
    }

    public int solution2(int n){
        int answer = 0;
        while (n != 0) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        자릿수더하기 sol = new 자릿수더하기();
        int n = 987;
        System.out.println(sol.solution(n));
        System.out.println(sol.solution2(n));
    }
}
