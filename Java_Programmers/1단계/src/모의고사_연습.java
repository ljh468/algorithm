public class 모의고사_연습 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] solve = {0, 0, 0};
        // 1. 맞춘 문제의 갯수를 solve배열에 저장
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == one[i % one.length]) solve[0]++;
            if(answers[i] == two[i % two.length]) solve[1]++;
            if(answers[i] == three[i % three.length]) solve[2]++;
        }
        // 2. 최대로 맞춘 문제의 갯수
        int max_val =  0;
        for(int sol : solve){
            if(max_val < sol){
                max_val = sol;
            }
        }
        // 3. 맞춘 인원의 수
        int size = 0;
        for(int sol : solve){
            if (sol == max_val) {
                size++;
            }
        }
        // 4. 맞춘 인원을 담을 배열생성
        int[] answer = new int[size];
        int num = 0;
        for (int i = 0; i < solve.length; i++) {
            if (solve[i] == max_val) {
                answer[num++] = i+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        모의고사_연습 sol = new 모의고사_연습();
        int[] answers = {1,3,2,4,2};
        int[] solution = sol.solution(answers);

        for (int i : solution) {
            System.out.println("solution = " + i);
        }
    }
}
