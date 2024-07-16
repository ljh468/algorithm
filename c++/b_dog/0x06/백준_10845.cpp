#include <iostream>
#include <queue>
#include <string>
using namespace std;

const int MX = 1000005;
int dat[MX];
int head, tail = 0;

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int n;
  cin >> n;
  while (n--) {
    string op;
    cin >> op;
    if (op == "push") {
      int num;
      cin >> num;
      dat[tail++] = num;
      if(tail == MX) {
        tail = 0;
      }
    } else if (op == "pop") {
      if (tail == head) {
        cout << -1 << '\n';
      } else {
        cout << dat[head++] << '\n';
        if (head == MX) {
          head = 0;
        }
      }
    } else if (op == "size") {
      cout << (tail - head) << '\n';
    } else if (op == "empty") {
      cout << (tail == head) << '\n';
    } else if (op == "front") {
      if (tail == head) {
        cout << -1 << '\n';
      } else {
        cout << dat[head] << '\n';
      }
    } else if (op == "back") {
      if (tail == head) {
        cout << -1 << '\n';
      } else {
        cout << dat[tail - 1] << '\n';
      }
    }
  }
  return 0;
}

// 큐 자료구조를 이용한 풀이
// int main(void) {
//   ios::sync_with_stdio(0);
//   cin.tie(0);

//   queue<int> Q;
//   int n;
//   cin >> n;
//   while (n--) {
//     string q;
//     cin >> q;
//     if (q == "push") {
//       int val;
//       cin >> val;
//       Q.push(val);
//     } else if (q == "pop") {
//       if (Q.empty())
//         cout << -1 << '\n';
//       else {
//         cout << Q.front() << '\n';
//         Q.pop();
//       }
//     } else if (q == "size") {
//       cout << Q.size() << '\n';
//     } else if (q == "empty") {
//       cout << Q.empty() << '\n';
//     } else if (q == "front") {
//       if (Q.empty())
//         cout << -1 << '\n';
//       else
//         cout << Q.front() << '\n';
//     } else {  // back
//       if (Q.empty())
//         cout << -1 << '\n';
//       else
//         cout << Q.back() << '\n';
//     }
//   }
// }