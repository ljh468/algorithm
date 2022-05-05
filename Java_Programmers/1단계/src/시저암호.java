public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        n = n % 26;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                System.out.println(ch); // z
                System.out.println((int)ch); // 122

                // 1. char에 'a'를 빼주어 26자중 몇번째인지 확인
                System.out.println("몇번째 알파벳? : " + (ch - 'a')); // 25
                // 2. 자리수에서 +n 만큼 밀기
                System.out.println("+n : " + (ch - 'a' + n)); // 25 + 4
                // 3. 밀어낸 숫자에서 26을 나눈 나머지를 하면 26개 알파벳중 몇번째인지 확인
                System.out.println("몇번째 알파벳? : " + (ch - 'a' + n) % 26); // 29 % 26 = 3
                // 4. + 'a'를 하여 a부터 몇번 밀렸는지 계산
                System.out.println("+ 'a' : " + ((ch - 'a' + n) % 26 + 'a')); // 3 + 97
                System.out.println("문자로 치환 : " + (char)((ch - 'a' + n) % 26 + 'a'));
                System.out.println();
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if(Character.isUpperCase(ch)){
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            answer += ch;
        }
        return answer;
    }

    public static void main(String[] args) {
        시저암호 sol = new 시저암호();
        String s = "a B z";
        int n = 4;
        System.out.println(sol.solution(s, n));
    }
}
