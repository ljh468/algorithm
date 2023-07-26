package 스택;

import java.util.Scanner;
import java.util.Stack;

public class _04_후위식연산 {

  public int solution1(String str) {
    Stack<Integer> stack = new Stack<>();
    for (char ch : str.toCharArray()) {
      if (Character.isDigit(ch)) {
        stack.push(ch - 48);
      } else {
        int rt = stack.pop();
        int lt = stack.pop();
        if (ch == '+') {
          stack.push(lt + rt);
        } else if (ch == '-') {
          stack.push(lt - rt);
        } else if (ch == '*') {
          stack.push(lt * rt);
        } else if (ch == '/') {
          stack.push(lt / rt);
        }
      }
    }
    return stack.get(0);
  }
  public static void main(String[] args) {
    _04_후위식연산 t = new _04_후위식연산();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(t.solution1(str));
  }
}
