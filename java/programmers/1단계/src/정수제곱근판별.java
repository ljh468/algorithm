public class 정수제곱근판별 {
    public long solution(long n) {
        if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }
        return -1;
    }
    public static void main(String[] args) {
        정수제곱근판별 sol = new 정수제곱근판별();
        long n = 121;
        System.out.println(sol.solution(n));
    }
}
