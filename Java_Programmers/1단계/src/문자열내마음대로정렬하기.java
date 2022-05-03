import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) < o2.charAt(n)) return -1;
                else if(o1.charAt(n) > o2.charAt(n)) return 1;
                else{
                    return o1.compareTo(o2);
                }
            }
        });
        return strings;
    }
    public String[] solution2(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, Comparator.comparing((s) -> s.substring(n, n + 1)));
        return strings;
    }
    public static void main(String[] args) {
        문자열내마음대로정렬하기 sol = new 문자열내마음대로정렬하기();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        System.out.println(Arrays.toString(sol.solution(strings, n)));
        System.out.println(Arrays.toString(sol.solution2(strings, n)));
    }
}
