public class 가운데글자가져오기 {
    public String solution(String s) {
        int len = s.length();
        return s.substring((len-1) / 2, (len/2) + 1);
    }

    public static void main(String[] args) {
        가운데글자가져오기 sol = new 가운데글자가져오기();
        String s = "qwer";
        System.out.println(sol.solution(s));
    }
}
