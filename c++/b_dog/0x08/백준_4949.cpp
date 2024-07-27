#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  while (true) {
    string str;
    getline(cin, str);
    if (str == ".") break;

    stack<char> st;
    bool isValid = true;
    for (char c : str) {
      if (c == '(' || c == '[') {
        st.push(c);
      } else if (c == ')') {
        if (st.empty() || st.top() != '(') {
          isValid = false;
          break;
        }
        st.pop();
      } else if (c == ']') {
        if (st.empty() || st.top() != '[') {
          isValid = false;
          break;
        }
        st.pop();
      }
    }

    if (!st.empty()) {
      isValid = false;
    }
    if (isValid) {
      cout << "yes\n";
    } else {
      cout << "no\n";
    }
  }
  return 0;
}