public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        answer += phone_number.substring(phone_number.length() - 4);
        return answer;
    }
    public String solution2(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        핸드폰번호가리기 sol = new 핸드폰번호가리기();
        String phone_number = "01033334444";
        System.out.println(sol.solution(phone_number));
        System.out.println(sol.solution2(phone_number));
    }
}
