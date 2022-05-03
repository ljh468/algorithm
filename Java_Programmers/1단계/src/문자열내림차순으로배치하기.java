import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split("");
        Arrays.sort(split, Collections.reverseOrder());
        for (String s1 : split) {
            answer += s1;
        }
        return answer;
    }
    public String solution2(String s){
        char[] split = s.toCharArray();
        Arrays.sort(split);
        return new StringBuilder(new String(split)).reverse().toString();
    }
    public String solution3(String s){
        return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        문자열내림차순으로배치하기 sol = new 문자열내림차순으로배치하기();
        String s = "Zbcdefg";
        System.out.println(sol.solution(s));
        System.out.println(sol.solution2(s));
        System.out.println(sol.solution3(s));
    }
}
