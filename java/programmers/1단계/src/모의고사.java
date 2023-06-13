public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] solve = {0, 0, 0};
        
        // 1. 맞춘 문제의 갯수를 solve배열에 저장
        for (int i = 0; i < answers.length; i++) {
            if(one[i % one.length] == answers[i]) solve[0]++;
            if(two[i % two.length] == answers[i]) solve[1]++;
            if(three[i % three.length] == answers[i]) solve[2]++;
        }
        // 2. 최대로 맞춘 문제의 갯수
        int max_value = 0;
        for (int value : solve) {
            if (max_value < value) {
                max_value = value;
            }
        }

        // 3. 최대로 맞춘 인원의 수
        int size = 0;
        for (int k : solve) {
            if (k == max_value) {
                size++;
            }
        }
        // 4. 맞춘 인원을 담을 배열생성
        int[] answer = new int[size];
        int num = 0;
        for (int j = 0; j < solve.length; j++) {
            if(max_value == solve[j]){
                answer[num++] = j+1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        모의고사 sol = new 모의고사();
        int[] answers = {1,2,3,4,5};
        int[] solution = sol.solution(answers);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
