import java.time.DayOfWeek;
import java.time.LocalDate;

public class 이공일육년 {
    public String solution(int a, int b) {
        String[] dateArr = {"0","MON","TUE","WED","THU","FRI","SAT","SUN"};
        LocalDate date = LocalDate.of(2016, a, b);
        int dayOfWeekNumber = date.getDayOfWeek().getValue();
        return dateArr[dayOfWeekNumber];
    }
    public String solution2(int a, int b) {
        String answer = "";

        int[] c = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] MM ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int Adate = 0;
        for(int i = 0 ; i< a-1; i++){
            Adate += c[i];
        }
        Adate += b-1;
        answer = MM[Adate %7];

        return answer;
    }

    public static void main(String[] args) {
        이공일육년 sol = new 이공일육년();
        int a = 5;
        int b = 24;
        System.out.println(sol.solution(a, b));
        System.out.println(sol.solution2(a, b));
    }
}
