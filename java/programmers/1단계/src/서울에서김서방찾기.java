import java.util.Arrays;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim"))
                return "김서방은 " + i + "에 있다";
        }
        return "";
    }
    public String solution2(String[] seoul){
        int x = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 "+ x + "에 있다";
    }

    public static void main(String[] args) {
        서울에서김서방찾기 sol = new 서울에서김서방찾기();
        String[] seoul = {"Jane", "Kim"};
        System.out.println(sol.solution(seoul));
    }
}
