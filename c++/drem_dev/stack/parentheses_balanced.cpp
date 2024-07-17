#include <iostream>
#include <stack>
#include <string>
using namespace std;

// 두문자가 짝이 맞는지 확인하는 메서드
bool isMatchingPair(char first, char second) {
  if (first == '(' && second == ')') {
    return true;
  } else if (first == '{' && second == '}') {
    return true;
  } else if (first == '[' && second == ']') {
    return true;
  }
  return false;
}

// 주어진 괄호 문자열이 올바르게 짝이 맞는지 확인하는 함수
bool areParenthesesBalanced(string expression) {
  stack<char> stack;  // 여는괄호를 저장할 스택

  for (char ch : expression) {
    // 여는 괄호는 스택에 저장
    if (ch == '(' || ch == '{' || ch == '[') {
      stack.push(ch);
    }
    // 닫는 괄호는 스택을 확인
    if (ch == ')' || ch == '}' || ch == ']') {
      // 스택이 비어있으면 X
      if (stack.empty()) {
        return false;
      }
      // 스택의 가장 최근에 들어간 원소와 비교하여 짝이 맞지 않으면 X
      else if (isMatchingPair(stack.top(), ch) == false) {
        return false;
      }
      // 짝이 맞으면 스택에서 여는괄호 제거
      else {
        stack.pop();
      }
    }
  }
  // 스택이 비어있으면 모든 괄호가 짝이 맞음, 스택에 남아있으면 짝이 맞지 않음
  return stack.empty();
}

void do_test(string expression) {
  cout << expression + ": ";
  if (areParenthesesBalanced(expression)) {
    cout << "괄호 짝이 맞음" << '\n';
  } else {
    cout << "괄호 짝이 맞지 않음" << '\n';
  }
};

int main() {
  // 시간 복잡도: O(n) 각 테스트 케이스에 대해
  do_test("{}({})");  // 올바르게 짝이 맞는 경우

  do_test("{{({})");  // 여는 괄호가 더 많은 경우

  do_test("{}({))");  // 닫는 괄호가 더 많은 경우

  return 0;
}