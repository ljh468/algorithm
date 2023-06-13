public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = money;
        for (int i = 1; i <= count; i++) {
            answer -= ((long) price * i);
        }
        return (answer > 0) ? 0 : -answer;
    }

    public static void main(String[] args) {
        부족한금액계산하기 sol = new 부족한금액계산하기();
        int price = 3;  // 이용금액
        int money = 20; // 잔액
        int count = 4;  // 이용횟수
        System.out.println(sol.solution(price, money, count));
    }
}
