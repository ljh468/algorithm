#include <iostream>
#include <stack>
#include <string>
using namespace std;

int n;
string op;

const int MX = 1000005;
int pos = 0;
int dat[MX];

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> n;
  while (n--) {
    cin >> op;
    if (op == "push") {
      int num;
      cin >> num;
      dat[pos++] = num;
    } else if (op == "pop") {
      if (pos == 0) {
        cout << -1 << '\n';
      } else {
        cout << dat[pos - 1] << "\n";
        pos--;
      }
    } else if (op == "size") {
      cout << pos << "\n";
    } else if (op == "empty") {
      if (pos == 0) {
        cout << 1 << "\n";
      } else if (pos > 0) {
        cout << 0 << "\n";
      }
    } else if (op == "top") {
      if (pos == 0) {
        cout << -1 << "\n";
      } else {
        cout << dat[pos - 1] << "\n";
      }
    }
  }
  return 0;
}

// 스택 자료구조를 이용한 풀이
// int main(void) {
//   ios::sync_with_stdio(0);
//   cin.tie(0);
//   int n;
//   cin >> n;
//   stack<int> S;
//   while (n--) {  // n번 반복
//     string c;
//     cin >> c;
//     if (c == "push") {
//       int t;
//       cin >> t;
//       S.push(t);
//     } else if (c == "pop") {
//       if (S.empty())
//         cout << -1 << '\n';
//       else {
//         cout << S.top() << '\n';
//         S.pop();
//       }
//     } else if (c == "size")
//       cout << S.size() << '\n';
//     else if (c == "empty")
//       cout << (int)S.empty() << '\n';
//     else {  // top
//       if (S.empty())
//         cout << -1 << '\n';
//       else
//         cout << S.top() << '\n';
//     }
//   }
// }