import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/****************************************************************************
 * 1번 문제 : 인터페이스를 사용하는 이유와 DI에 대해 간단히 서술하시오.
 * 인터페이스는 구현부가 없는 추상메서드의 집합, 구현부가 없는 설계도
 * 설계와 구현을 분리하여 느슨한 결합을 유지하여 변경에 용이하고 유연한코드를 작성할 수 있다.
 * 서로 관계가 없는 클래스들을 인터페이스를 공통으로 상속받아서 관계를 맺어 줄 수 있다. *
 ****************************************************************************/
/****************************************************************************
 * 2번 문제 : @Controller와 @RestController의 차이를 간단히 서술하시오.
 * Controller는 ViewResolver 설정에 맞는 view를 반환하고
 * RestController는 클라이언트 요청에 객체 데이터 자체를 반환(JSON)
 ****************************************************************************/
/****************************************************************************
 * 3번 문제 : 웹 서비스에 사용자가 아이디와 패스워드를 입력하고 로그인 버튼을 누르는 시점부터
 *           사용자 홈 화면이 나타나는 시점까지의 과정을 서술하시오.(Spring Architecture 기반)
 * 1. DispatcherServlet이 요청을 수신하고 HandlerMapping이 적절한 컨트롤러를 선택하여 Servlet에 반환합니다.
 * 2. Servlet은 Controller의 비즈니스 로직을 수행하는 작업을 HandlerAdapter에 전달하고
 *    HandlerAdapter는 Controller의 비즈니스 로직 프로세스를 호출합니다.
 * 3. Controller는 비즈니스 로직을 실행하고 처리결과를 Model에 담아 반환합니다.
 * 4. ViewResolver는 매핑된 view를 찾아 view를 반환하고 Servlet은 반환된 view를 랜더링하여 사용자에게 보여줍니다.
 ****************************************************************************/
/****************************************************************************
 * 4번 문제 : 함수형 인터페이스를 설명하시오
 * 1개의 추상 메소드만을  갖는 인터페이스를 함수형 인터페이스라고 합니다.
 * 여러 개의 디폴트 메서드가 있더라도 추상 메서드가 오직 하나면 함수형 인터페이스입니다.
 ****************************************************************************/
/****************************************************************************
 * 5번 문제 : JWT에 대하여 설명하시오
 *  JSON Web Token의 약자로 공개키, 개인키를 쌍으로 사용하여 토큰에 서명을 하여 안전하게 인증하는 방법
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
