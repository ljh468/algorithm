public class 콜라즈추측 {
    public int solution(int n) {
        int answer = 0;
        long num = (long)n;
        while(num != 1){
            if(num % 2 == 0){
                num = num / 2;
                answer++;
            }else if(num % 2 != 0){
                num = (num * 3) + 1;
                answer++;
            }
            if(answer >= 500) return -1;
        }
        return answer;
    }
    public int solution2(int num){
        long n = (long)num;
        for(int i =0; i<500; i++){
            if(n==1) return i;
            n = (n%2==0) ? n/2 : n*3+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        콜라즈추측 sol = new 콜라즈추측();
        int n = 626331;
        System.out.println(sol.solution(n));
        System.out.println(sol.solution2(n));
    }
}
