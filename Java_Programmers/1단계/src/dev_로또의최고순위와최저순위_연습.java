import java.util.Arrays;

public class dev_로또의최고순위와최저순위_연습 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int hidden = 0;
        int result = 0;
        for(int lotto : lottos){
            if(lotto == 0){
                hidden += 1;
                continue;
            }
            for(int win_num : win_nums){
                if(win_num == lotto){
                    result += 1;
                    break;
                }
            }
        }
        return new int[]{rank(result+hidden), rank(result)};
    }
    public int rank(int answer_count){
        return (answer_count <= 1) ? 6 : 7 - answer_count;
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
