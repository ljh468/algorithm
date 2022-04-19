import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/****************************************************************************
 * 1번 문제 : 인터페이스를 사용하는 이유와 DI에 대해 간단히 서술하시오.
 ****************************************************************************/
/****************************************************************************
 * 2번 문제 : @Controller와 @RestController의 차이를 간단히 서술하시오.
 ****************************************************************************/
/****************************************************************************
 * 3번 문제 : 웹 서비스에 사용자가 아이디와 패스워드를 입력하고 로그인 버튼을 누르는 시점부터
 *           사용자 홈 화면이 나타나는 시점까지의 과정을 서술하시오.(Spring Architecture 기반)
 ****************************************************************************/
/****************************************************************************
 * 4번 문제 : 함수형 인터페이스를 설명하시오
 ****************************************************************************/
/****************************************************************************
 * 5번 문제 : JWT에 대하여 설명하시오
 ****************************************************************************/

public class 석세스모드_코딩테스트 {
    /**
     *  1. 아래와 문자열을 인자로 가지는 리스트가 주어진 경우, 이를 int형 배열로 변환하는 메서드를 작성하시오.
     */
    public int[] solution(List<String> values) {
        return values.stream().filter(this::isInt).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * 2. (sample.dat)에 개인정보가 존재하는 경우, 중복 데이터를 제거하는 로직을 구현하시오.
     */
    public String[] solution2(String[] samples) {
        HashSet<String> infoSet = new HashSet<>(Arrays.asList(samples));
        String[] answer = new String[infoSet.size()];
        int ansNum = 0;
        for (String s : infoSet) {
            answer[ansNum++] = s;
        }
        return answer;
    }
    public static void main(String[] args) {
        석세스모드_코딩테스트 sol = new 석세스모드_코딩테스트();
        /**
         * 1번 문제
         */
        List<String> values = List.of("1", "12", "123");
        int[] result = sol.solution(values);
        printArray(result);
        System.out.println("#################################################");

        values = List.of("A", "2", "A2", "3");
        result = stringArrayToIntArray(values);
        printArray(result);
        System.out.println("#################################################");
        /**
         * 2번 문제
         */
        String[] info = {
                "이름 전화번호 이메일",
                "kkk 010-1234-1234 a@a.com",
                "yyy 010-2345-2345 b@b.com",
                "hhh 010-3456-3456 c@c.com",
                "kkk 010-1234-1234 a@a.com",
                "yyy 010-2345-2345 b@b.com",
                "hhh 010-3456-3456 c@c.com",
                "kkk 010-1234-1234 a@a.com",
                "yyy 010-2345-2345 b@b.com",
                "hhh 010-3456-3456 c@c.com"
        };
        String[] answers = sol.solution2(info);
        for (String answer : answers) {
            System.out.println("answer = " + answer);
        }
    }

    public static void printArray(int[] array) {
        // 구현
        for (int i : array) {
            System.out.println("result = " + i);
        }
    }

    public static int[] stringArrayToIntArray(List<String> values) {
        // 구현
        석세스모드_코딩테스트 sol = new 석세스모드_코딩테스트();
        return values.stream().filter(sol::isInt).mapToInt(Integer::parseInt).toArray();
    }

    private boolean isInt(String str){
        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }
}
