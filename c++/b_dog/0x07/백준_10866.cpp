#include <deque>
#include <iostream>
using namespace std;

const int MX = 1000005;
int dat[2 * MX + 1];
int head = MX, tail = MX;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  while (n--) {
    string q;
    cin >> q;
    if (q == "push_back") {
      int num;
      cin >> num;
      dat[tail++] = num;
    } else if (q == "push_front") {
      int num;
      cin >> num;
      dat[--head] = num;
    } else if (q == "pop_front") {
      if (tail == head) {
        cout << -1 << '\n';
      } else {
        cout << dat[head] << '\n';
        head++;
      }
    } else if (q == "pop_back") {
      if (tail == head) {
        cout << -1 << '\n';
      } else {
        cout << dat[tail - 1] << '\n';
        tail--;
      }
    } else if (q == "size") {
      cout << tail - head << '\n';
    } else if (q == "empty") {
      cout << (tail == head) << '\n';
    } else if (q == "front") {
      if (tail == head) {
        cout << -1 << '\n';
      } else {
        cout << dat[head] << '\n';
      }
    } else {  // back
      if (tail == head) {
        cout << -1 << '\n';
      } else {
        cout << dat[tail - 1] << '\n';
      }
    }
  }
}

// 덱 자료구조를 이용한 풀이
// int main(void) {
//   ios::sync_with_stdio(0);
//   cin.tie(0);

//   deque<int> DQ;
//   int n;
//   cin >> n;
//   while (n--) {
//     string q;
//     cin >> q;
//     if (q == "push_back") {
//       int val;
//       cin >> val;
//       DQ.push_back(val);
//     } else if (q == "push_front") {
//       int val;
//       cin >> val;
//       DQ.push_front(val);
//     } else if (q == "pop_front") {
//       if (DQ.empty())
//         cout << -1 << '\n';
//       else {
//         cout << DQ.front() << '\n';
//         DQ.pop_front();
//       }
//     } else if (q == "pop_back") {
//       if (DQ.empty())
//         cout << -1 << '\n';
//       else {
//         cout << DQ.back() << '\n';
//         DQ.pop_back();
//       }
//     } else if (q == "size")
//       cout << DQ.size() << '\n';
//     else if (q == "empty")
//       cout << DQ.empty() << '\n';
//     else if (q == "front") {
//       if (DQ.empty())
//         cout << -1 << '\n';
//       else
//         cout << DQ.front() << '\n';
//     } else {  // back
//       if (DQ.empty())
//         cout << -1 << '\n';
//       else
//         cout << DQ.back() << '\n';
//     }
//   }
// }