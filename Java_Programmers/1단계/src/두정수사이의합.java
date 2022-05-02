public class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        if(a == b) return a;
        if(b < a){
            int temp = a;
            a = b;
            b = temp;
        }
        for(int i = a; i <= b; i++){
            answer += i;
        }
        return answer;
    }
    public long solution2(int a, int b){
        if(a == b) return a;
        if(b < a){
            int temp = a;
            a = b;
            b = temp;
        }
        return sumAtoB(a, b);
    }
    // 등차수열의 합공식 :  n(a + l) /2
    public long sumAtoB(int a, int b){
        return ((long) (b - a + 1) *(a+b) / 2);
    }

    public static void main(String[] args) {
        두정수사이의합 sol = new 두정수사이의합();
        int a = 3;
        int b = 5;
        System.out.println(sol.solution(a, b));
        System.out.println(sol.solution2(a, b));
    }
}
