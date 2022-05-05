import java.util.*;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        // 1. 배열을 리스트로 변환
//        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        // 2. 최소값 찾기
//        int min = Arrays.stream(arr).min().getAsInt();
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(min > arr[i]) min = arr[i];
        }

        // 3. list에서 최소값 제거
        list.remove(Integer.valueOf(min));
        if(list.size() == 0){
            return new int[]{-1};
        }
        // 4. 리스트를 배열로 바꿔서 반환
        int[] answer = new int[list.size()];
        for (int j = 0; j < answer.length; j++) {
            answer[j] = list.get(j);
        }
        return answer;
    }
    public int[] solution2(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        // 배열에서 가장 작은 값 찾기
        int min = Arrays.stream(arr).min().getAsInt();
        // 배열에서 가장 작은값이 제거된 배열 반환
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
    public static void main(String[] args) {
        제일작은수제거하기 sol = new 제일작은수제거하기();
        int[] arr = {4, 3, 2, 1};
        System.out.println(Arrays.toString(sol.solution(arr)));
        System.out.println(Arrays.toString(sol.solution2(arr)));
    }
}
