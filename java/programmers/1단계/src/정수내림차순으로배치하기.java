import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {
    String res = "";
    public long solution(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        String join = String.join("", arr);
        long answer = Long.valueOf(join);
        return answer;
    }
    public long solution2(long n){
        res = "";
        Long.toString(n).chars().sorted().forEach(c -> res = (char) c + res);
        return Long.parseLong(res);
    }
    public static void main(String[] args) {
        정수내림차순으로배치하기 sol = new 정수내림차순으로배치하기();
        long n = 118372;
        System.out.println(sol.solution(n));
        System.out.println(sol.solution2(n));
    }
}
