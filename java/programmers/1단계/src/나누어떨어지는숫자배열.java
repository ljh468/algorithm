import java.util.*;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            if (a % divisor == 0) {
                list.add(a);
            }
        }
        if (list.size() == 0) {
            return new int[]{-1};
        }
        list.sort(Comparator.naturalOrder());
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public int[] solution2(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(a -> a % divisor == 0).toArray();
        if(answer.length == 0) answer = new int[]{-1};
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        나누어떨어지는숫자배열 sol = new 나누어떨어지는숫자배열();
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        System.out.println(Arrays.toString(sol.solution(arr, divisor)));
        System.out.println(Arrays.toString(sol.solution2(arr, divisor)));
    }
}
