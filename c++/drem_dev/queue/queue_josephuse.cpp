#include <iostream>
#include <queue>
using namespace std;

int josephus(int n, int k) {
  // 1. 큐 초기화 & 요소 삽입 (1부터 n까지) - 시간복잡도 : O(n)
  queue<int> queue;
  for (int i = 1; i <= n; i++) {
    queue.push(i);
  }

  // 2. k번째 요소 제거 - 시간복잡도 : O(n * k)
  while (queue.size() > 1) {
    // (k-1)번째의 요소까지는 다시 큐의 맨뒤로 보냄
    for (int i = 0; i < k - 1; i++) {
      queue.push(queue.front());
      queue.pop();
    }
    // k번째 요소 제거
    queue.pop();
  }

  return queue.front();
}

int main() {
  int N = 10;  // 10명의 사람
  int K = 4;   // 4번째 사람 제거

  // 생존자를 출력합니다.
  cout << "생존자 : " << josephus(N, K) << '\n';
  return 0;
}