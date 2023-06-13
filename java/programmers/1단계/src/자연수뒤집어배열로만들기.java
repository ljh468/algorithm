import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        int num = 0;
        while(n > 0){
            answer[num++] = (int)(n % 10);
            n = n / 10;
        }
        return answer;
    }
    public static void main(String[] args) {
        자연수뒤집어배열로만들기 sol = new 자연수뒤집어배열로만들기();
        long n = 12345;
        System.out.println(Arrays.toString(sol.solution(n)));
    }
}
