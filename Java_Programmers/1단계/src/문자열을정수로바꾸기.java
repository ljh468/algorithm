public class 문자열을정수로바꾸기 {
    public int solution(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        문자열을정수로바꾸기 sol = new 문자열을정수로바꾸기();
        String s = "-1234";
        System.out.println(sol.solution(s));
    }
}
