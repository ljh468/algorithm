public class 소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++){
                for (int k = j+1; k < nums.length; k++) {
                    int combin = nums[i] + nums[j] + nums[k];
                    if(isPrime(combin)){
                        answer ++;
                    }
                }
            }
        }
        return answer;
    }
    public boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        소수만들기 sol = new 소수만들기();
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(sol.solution(nums));
    }

}
