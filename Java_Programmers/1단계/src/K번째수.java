import java.util.Arrays;

public class K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        // 1. 결과를 담을 배열
        int[] answer = new int[commands.length];
        
        // 2. commands의 요소를 가지고 array를 자른 배열 만들기
        int selected = 0;
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1] - 1;
            int select = command[2] - 1;

            int[] nums = Arrays.copyOfRange(array, start, end + 1);
            Arrays.sort(nums);
            answer[selected] = nums[select];
            selected++;
        }
        return answer;
    }
    public static void main(String[] args) {
        K번째수 sol = new K번째수();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = sol.solution(array, commands);
        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }
}
