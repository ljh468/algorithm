public class 하샤드수 {
    public boolean solution(int x) {
        String[] str = String.valueOf(x).split("");
        int sum = 0;
        for (String s : str) {
            sum += Integer.parseInt(s);
        }
        return x % sum == 0;
    }
    public boolean solution2(int num){
        int sum = 0;
        int n = num;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return num % sum == 0;
    }
    public static void main(String[] args) {
        하샤드수 sol = new 하샤드수();
        int x = 12;
        System.out.println(sol.solution(x));
        System.out.println(sol.solution2(x));
    }
}
