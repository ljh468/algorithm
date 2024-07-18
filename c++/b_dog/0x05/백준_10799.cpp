#include <iostream>
#include <stack>
#include <string>
using namespace std;

string parentheses;
stack<char> st;
int result = 0;

int main() {
  // '(' ')'가 연달아 오면 레이져, 레이져가 되면, 스택의 '('는 pop();
  // 그리고 남아있는 스택의 사이즈 만큼 쇠막대기가 토막남 [result +=
  // stack.size()]
  // ')'가 올때 이전에 ')'있으면 막대기의 끝이므로 스택에서 '('를 제거함,
  // 쇠막대기가 끝났으므로 [result += 1]
  ios::sync_with_stdio(0), cin.tie(0);

  cin >> parentheses;
  for (int i = 0; i < parentheses.size(); i++) {
    // 여는 괄호
    if (parentheses[i] == '(') {
      st.push('(');
    }
    // 닫는 괄호
    else {
      st.pop(); // 닫는괄호라면, 스택에서 여는괄호 제거
      
      // 1. 레이져인 경우 처리
      if (parentheses[i - 1] == '(') {
        result += st.size();
      }
      // 2. 막대기의 끝인 경우 처리
      else {
        result++;
      }
    }
    
  }
  cout << result << '\n';
  return 0;
}