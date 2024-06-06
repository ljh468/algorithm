package _재귀;

/**
 * 콜스택 : 함수가 호출되면서 올라가는 메모리 영역으로 스택이라고도 부름 (Last In First Out)
 * - 코드, 데이터, 힙, 스택 영역이 존재, 콜스택은 스택영역을 말함
 */
public class Recursion {

  public void myFunction(int number) {
    // 기저조건
    if(number > 10) {
      return;
    }
    System.out.println("number = " + number);
    myFunction(number + 1);
  }

  public static void main(String[] args) {
    Recursion recursion = new Recursion();
    recursion.myFunction(1);
  }

}


