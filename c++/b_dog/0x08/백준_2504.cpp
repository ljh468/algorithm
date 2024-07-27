#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<char> s;
string str;

int main(void) {
  ios::sync_with_stdio(0), cin.tie(0);

  cin >> str;
  int sum = 0;  // 최종 결과를 누적하는 변수
  int num = 1;  // 현재 레벨의 계산된 값을 추적

  for (int i = 0; i < str.size(); i++) {
    if (str[i] == '(') {
      num *= 2;        // ( 시작: 값을 두 배로
      s.push(str[i]);  // 스택에 '(' 푸시
    } else if (str[i] == '[') {
      num *= 3;        // [ 시작: 값을 세 배로
      s.push(str[i]);  // 스택에 '[' 푸시
    } else if (str[i] == ')') {
      if (s.empty() || s.top() != '(') {
        cout << 0;  // 잘못된 구조면 0 반환
        return 0;
      }
      if (str[i - 1] == '(') sum += num;  // '()' 완성: 값 추가
      s.pop();                            // '(' 제거
      num /= 2;                           // ')' 완성: 값을 원래대로
    } else if (str[i] == ']') {
      if (s.empty() || s.top() != '[') {
        cout << 0;  // 잘못된 구조면 0 반환
        return 0;
      }
      if (str[i - 1] == '[') sum += num;  // '[]' 완성: 값 추가
      s.pop();                            // '[' 제거
      num /= 3;                           // ']' 완성: 값을 원래대로
    }
  }
  if (s.empty())
    cout << sum;  // 스택이 비어 있으면 최종 결과 출력
  else
    cout << 0;  // 스택에 남아있으면 잘못된 구조로 간주
}