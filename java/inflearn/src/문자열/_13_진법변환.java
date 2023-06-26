 package 문자열;

public class _13_진법변환 {
  public static void main(String[] args) {
    _13_진법변환 t = new _13_진법변환();
    int decimal1 = t.binaryToDecimal("101000101");
    int decimal2 = Integer.parseInt("101000101", 2);
    System.out.println("result1 = " + decimal1);
    System.out.println("decimal = " + decimal2);

    String binary1 = t.decimalToBinary(325);
    String binary2 = Integer.toBinaryString(325);
    System.out.println("binary1 = " + binary1);
    System.out.println("binary2 = " + binary2);

  }

  public int binaryToDecimal(String str) {
    int answer = 0;
    int count = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      double pow = Math.pow(2, count);
      int num = str.charAt(i) - '0';
      answer += pow * num;
      count++;
    }
    return answer;
  }

  public String decimalToBinary(int num) {
    String answer = "";
    while (num > 0) {
      int mok = num / 2;
      int mod = num % 2;
      answer += mod;
      num = mok;
    }
    return new StringBuilder(answer).reverse().toString();
  }
}
