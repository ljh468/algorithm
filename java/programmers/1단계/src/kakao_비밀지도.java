import java.util.Arrays;

public class kakao_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        // 1. 이진수로 바꾼 문자열 비교
        for (int i = 0; i < n; i++) {
            result[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            // 2. 빈자리 0으로 채우기
            if(result[i].length() < n){
                result[i] = "0".repeat((n-result[i].length())) + result[i];
            }
        }
        // 3. 1은 "#" 0은 " "으로 변환하기
        for (int i = 0; i < n; i++) {
            result[i] = result[i].replaceAll("1", "#");
            result[i] = result[i].replaceAll("0", " ");
        }
        return result;
    }

    public static void main(String[] args) {
        kakao_비밀지도 sol = new kakao_비밀지도();
        int n = 5;
        int[] arr1 = {0, 0, 0, 0, 0};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));
    }
}
