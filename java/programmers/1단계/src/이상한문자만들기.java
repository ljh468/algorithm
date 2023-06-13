import java.util.Arrays;

public class 이상한문자만들기 {
    public String solution(String s) {
        String[] str = s.split(" ", -1);
        System.out.println(Arrays.toString(str));
        int num = 0;
        for (String st : str) {
            String temp = "";
            for (int i = 0; i < st.length(); i++) {
                // 짝수
                if (i % 2 == 0) {
                    temp += Character.toUpperCase(st.charAt(i));
                }
                // 홀수
                else {
                    temp += Character.toLowerCase(st.charAt(i));
                }
            }
            str[num++] = temp;
        }
        return String.join(" ", str);
    }

    public String solution2(String s) {
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");
        for(String ss : array) {
            cnt = (ss.equals(" ")) ? 0 : cnt+1;
            answer += cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }

    public static void main(String[] args) {
        이상한문자만들기 sol = new 이상한문자만들기();
        String s = "try hello world  ";
//        System.out.println(sol.solution(s));
        System.out.println(sol.solution2(s));
    }
}
