#include <iostream>
#include <queue>
using namespace std;

int n;
int k;

void josephus(int n, int k) {
  // 1. 큐 초기화 & 요소 삽입 (1부터 n까지) - 시간복잡도 : O(n)
  queue<int> queue;
  for (int i = 1; i <= n; i++) {
    queue.push(i);
  }
  cout << "<";
  // 2. k번째 요소 제거
  while(queue.empty() == false) {
    // (k-1)번째의 요소까지는 다시 큐의 맨뒤로 보냄
    for (int i = 0; i < k - 1; i++) {
      queue.push(queue.front());
      queue.pop();
    }
    // k번째 요소 제거
    cout << queue.front();
    queue.pop();
    if(queue.empty() == false) {
      cout << ", ";
    }
  }
  cout << ">";
}

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> n;
  cin >> k;
  josephus(n, k);
  return 0;
}