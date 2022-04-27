public class 진법뒤집기 {
    public int solution(int n) {
        String ans = "";
        // 먼저 나누었을때 나머지 부터 차례대로 문자열에 붙임
        while(n != 0) {
            ans = ans + (n % 3);
            n /= 3;
        }
        // Integer.parseInt(문자열, n)을 하면 n진법으로 나옴
        return Integer.parseInt(ans, 3);
    }

    public static void main(String[] args) {
        진법뒤집기 sol = new 진법뒤집기();
        int n = 125;
        System.out.println(sol.solution(n));
    }
}
