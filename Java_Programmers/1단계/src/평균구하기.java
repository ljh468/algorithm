import java.util.Arrays;

public class 평균구하기 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
    public double solution2(int[] arr) {
        double answer = 0;
        for (int i : arr) {
            answer+= i;
        }
        return answer / arr.length;
    }

    public static void main(String[] args) {
        평균구하기 sol = new 평균구하기();
        int[] arr = {1, 2, 3, 4};
        System.out.println(sol.solution(arr));
        System.out.println(sol.solution2(arr));
    }
}
