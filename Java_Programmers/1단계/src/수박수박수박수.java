public class 수박수박수박수 {
    public String solution(int n) {
        String answer = "";
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (num == 0) {
                answer += "수";
                num++;
            } else{
                answer += "박";
                num--;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        수박수박수박수 sol = new 수박수박수박수();
        int n = 3;
        System.out.println(sol.solution(n));
    }
}
