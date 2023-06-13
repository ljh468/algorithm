import java.util.HashMap;
import java.util.Map;

public class kakao_숫자문자열과영단어 {
    /********************************************************************************************************
     * 내 풀이
     ********************************************************************************************************/
    public int solution(String s) {
        HashMap<Integer, String> numbers = new HashMap<>();
                numbers.put(0, "zero");
                numbers.put(1, "one");
                numbers.put(2, "two");
                numbers.put(3, "three");
                numbers.put(4, "four");
                numbers.put(5, "five");
                numbers.put(6, "six");
                numbers.put(7, "seven");
                numbers.put(8, "eight");
                numbers.put(9, "nine");
        for(Map.Entry<Integer, String> number : numbers.entrySet()){
            if(s.contains(number.getValue())){
                s = s.replaceAll(number.getValue(), number.getKey() + "");
            }
        }
        return Integer.valueOf(s);
    }
    /********************************************************************************************************
     * 배열 하나만 이용
     ********************************************************************************************************/
    public int solution2(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
    /********************************************************************************************************
     * main
     ********************************************************************************************************/
    public void main(String[] args) {
        kakao_숫자문자열과영단어 sol = new kakao_숫자문자열과영단어();
        String s = "one4seveneight";
        System.out.println(sol.solution(s));
    }
}
