import java.util.*;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        s = s.toLowerCase(Locale.ROOT);
        Long pcnt =- s.chars().filter(ch -> ch == 'p').count();
        Long ycnt =- s.chars().filter(ch -> ch == 'y').count();
        if(pcnt != ycnt) return false;
        return true;
    }
    boolean solution2(String s) {
        s = s.toLowerCase(Locale.ROOT);
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p') cnt++;
            else if (s.charAt(i) == 'y') cnt--;
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        문자열내p와y의개수 sol = new 문자열내p와y의개수();
        String s = "pPoooyY";
        System.out.println(sol.solution(s));
        System.out.println(sol.solution2(s));
    }
}
