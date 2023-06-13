import java.util.Arrays;

public class 행렬의덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int size = arr1.length;
        int size2 = arr1[0].length;
        int[][] answer = new int[size][size2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size2; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        행렬의덧셈 sol = new 행렬의덧셈();
//        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr1 = {{1}, {2}};
//        int[][] arr2 = {{3, 4}, {5, 6}};
        int[][] arr2 = {{3}, {4}};
        System.out.println(Arrays.deepToString(sol.solution(arr1, arr2)));
    }
}
