import java.util.Arrays;

public class dev_로또의최고순위와최저순위_연습 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[]{};
        return answer;
    }
    /********************************************************************************************************
     * main
     ********************************************************************************************************/
    public static void main(String[] args) {
        dev_로또의최고순위와최저순위_연습 sol = new dev_로또의최고순위와최저순위_연습();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] solution = sol.solution(lottos, win_nums);
        System.out.println("sol1 = " + solution[0] + "," + solution[1]);
    }
}
