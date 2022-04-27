import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class 두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> numberHash = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                numberHash.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[numberHash.size()];
        int cnt = 0;
        for (Integer hash : numberHash) {
            answer[cnt++] = hash;
        }
        return answer;
    }

    public static void main(String[] args) {
        두개뽑아서더하기 sol = new 두개뽑아서더하기();
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(sol.solution(numbers)));
    }
}
