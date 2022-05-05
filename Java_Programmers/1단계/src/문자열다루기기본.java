public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    answer = false;
                }
            }
        } else return false;
        return answer;
    }
    public boolean solution2(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
    }

    public static void main(String[] args) {
        문자열다루기기본 sol = new 문자열다루기기본();
        String s = "1234";
        System.out.println(sol.solution(s));
    }
}
