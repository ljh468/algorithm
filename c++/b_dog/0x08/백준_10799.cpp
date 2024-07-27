#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  string str;
  getline(cin, str);

  stack<char> st;
  int result = 0;
  for (int i = 0; i < str.length(); i++) {
    // 여는 괄호는 스택에 넣어줌
    if (str[i] == '(') {
      st.push(str[i]);
    }
    // 닫는 괄호
    else {
      st.pop();
      // 레이져인지 확인 (닫는괄호 앞에 나온 값이 여는괄호일때)
      if (str[i - 1] == '(') {
        result += st.size();
      }
      // 레이져가 아니라면, 막대기의 끝이므로 +1
      else {
        result++;
      }
    }
  }

  cout << result << '\n';
  return 0;
}