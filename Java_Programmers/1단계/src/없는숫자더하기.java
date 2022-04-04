import java.util.Arrays;

public class 없는숫자더하기 {
    public static int solution(int[] numbers) {
        int answer = 45;
        for(int num : numbers){
            answer -= num;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println("solution(numbers) : " + solution(numbers));
    }
}
