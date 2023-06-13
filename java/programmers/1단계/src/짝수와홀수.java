public class 짝수와홀수 {
    public String solution(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }
    public static void main(String[] args) {
        짝수와홀수 sol = new 짝수와홀수();
        int num = 3;
        System.out.println(sol.solution(3));
    }
}
