import java.util.Arrays;

public class dev_로또의초고순위와최저순위 {
    /********************************************************************************************************
     * 내 풀이
     ********************************************************************************************************/
    private int rank(int num){
        return (num <= 1) ? 6 : 7 - num;
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int max_num = 0;
        int min_num = 0;

        for(int i : lottos){
            if(i == 0){
                max_num += 1;
                continue;
            }
            for(int j : win_nums){
                if(i == j){
                    min_num += 1;
                    break;
                }
            }
        }
        max_num += min_num;
        return new int[] {rank(max_num), rank(min_num)};
    }
    /********************************************************************************************************
     * 바이너리서치(이진탐색)를 이용한 풀이
     ********************************************************************************************************/
    public int[] solution2(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int answer = 0;
        int hidden = 0;

        Arrays.sort(win_nums);
        for (int i = 0; i < lottos.length; i++)
            if (Arrays.binarySearch(win_nums, lottos[i]) > -1)
                answer++;
            else if (lottos[i] == 0)
                hidden++;
        return new int[] {rank[answer + hidden], rank[answer]};
    }
    /********************************************************************************************************
     * main
     ********************************************************************************************************/
    public static void main(String[] args) {
        dev_로또의초고순위와최저순위 sol = new dev_로또의초고순위와최저순위();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] sol1 = sol.solution(lottos, win_nums);
        int[] sol2 = sol.solution2(lottos, win_nums);
        System.out.println("sol1 = " + sol1[0] + "," + sol1[1]);
        System.out.println("sol2 = " + sol2[0] + "," + sol2[1]);
    }
}
