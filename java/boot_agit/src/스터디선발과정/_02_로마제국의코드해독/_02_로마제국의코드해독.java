package 스터디선발과정._02_로마제국의코드해독;

import java.util.Map;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class _02_로마제국의코드해독 {

  // 로마 기호와 매핑되는 숫자를 저장할 map
  public static final Map<Character, Integer> romaNumberMap = Map.of('I', 1,
                                                                     'V', 5,
                                                                     'X', 10,
                                                                     'L', 50,
                                                                     'C', 100,
                                                                     'D', 500,
                                                                     'M', 1000);

  public void printIntFromRomaCode(String romaCode) {
    if (!isValidRomaCode(romaCode)) {
      System.out.println("잘못된 로마 숫자 표기입니다.");
      return;
    }

    int result = 0;
    int prevValue = 0;

    // 입력받은 로마 숫자 코드를 역순으로 반복하여 처리 (감산법 적용)
    for (int i = romaCode.length() - 1; i >= 0; i--) {
      int currentValue = romaNumberMap.get(romaCode.charAt(i));
      // 현재 값이 이전 값보다 크거나 같으면 더하고, 작으면 빼줌
      if (currentValue >= prevValue) {
        result += currentValue;
      } else {
        result -= currentValue;
      }
      // 이전 값 업데이트
      prevValue = currentValue;
    }

    // 변환된 숫자가 3999를 초과하는 경우 출력 & 함수종료
    if (result > 3999) {
      System.out.println("표현할 수 없는 범위의 수입니다.");
      return;
    }
    System.out.println(result);
  }

  private boolean isValidRomaCode(String code) {
    if (isNull(code) || code.isEmpty() || code.isBlank() || code.length() > 15) {
      return false;
    }
    /**
     * 로마 숫자 표기법으로 올 수 있는 지 확인하는 정규표현식
     * 1. M{0,3} - M은 3번까지 연속으로 올수 있음 (4000을 표기할 수 없기 때문)
     * 2. (CM|CD|D?C{0,3}) - 3가지 경우중 1가지가 올 수 있음
     * - CM(900)이 올 수 있음
     * - CD(400)이 올 수 있음
     * - D가 0번 또는 1번 올 수 있고, 그 뒤에 C가 0번에서 3번까지 올 수 있음 (500 ~ 800)
     * 3. (XC|XL|L?X{0,3}) - 3가지 경우중 1가지가 올 수 있음
     * - XC(90)이 올 수 있음
     * - XL(40)이 올 수 있음
     * - L이 0번 또는 1번 올 수 있고, 그 뒤에 X가 0번에서 3번까지 올 수 있음 (50 ~ 80)
     * 4. (IX|IV|V?I{0,3}) - 3가지 경우중 1가지가 올 수 있음
     * - IX(9)이 올 수 있음
     * - IV(40)이 올 수 있음
     * - V가 0번 또는 1번 올 수 있고, 그 뒤에 I가 0번에서 3번까지 올 수 있음 (1 ~ 3 or 6 ~ 8)
     */
    String validPattern = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    return code.matches(validPattern);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();

    _02_로마제국의코드해독 romaCode = new _02_로마제국의코드해독();
    romaCode.printIntFromRomaCode(str);
  }

}
