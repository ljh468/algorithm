#include <deque>
#include <iostream>
#include <vector>
using namespace std;

int n;
int value;

struct Balloon {
  int index;
  int value;
};

int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> n;

  deque<Balloon> balloons;
  // 풍선 초기화
  for (int i = 0; i < n; i++) {
    int value;
    cin >> value;
    balloons.push_back({i + 1, value});
  }

  vector<int> result;
  // 풍선 터트림 (가장 먼저 들어간 1번째 풍선부터)
  while (!balloons.empty()) {
    Balloon current = balloons.front();

    // 풍선 제거
    balloons.pop_front();
    result.push_back(current.index);

    // 이동할 step 종이 추출
    int steps = current.value;

    // 풍선이 없으면 while문 종료
    if (balloons.empty()) break;

    // 종이가 양수일 경우 오른쪽 이동이므로 "front에서 back으로 이동"
    // front의 풍선은 이미 터져 없어졌기 때문에 제외하고 (step-1) 만큼 이동
    if (steps > 0) {
      for (int i = 0; i < steps - 1; i++) {
        balloons.push_back(balloons.front());
        balloons.pop_front();
      }
    }
    // 종이가 음수일 경우 왼쪽 이동이므로 "back에서 front로 이동"
    // front의 풍선과 관계없이 back부터 이동하기 때문에 |step| 만큼 이동
    else {
      for (int i = 0; i < -(steps); i++) {
        balloons.push_front(balloons.back());
        balloons.pop_back();
      }
    }
  }

  // 결과 출력
  for (int index : result) {
    cout << index << " ";
  }

  return 0;
}