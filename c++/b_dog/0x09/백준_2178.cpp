#include <iostream>
#include <queue>
#include <string>
using namespace std;

string board[103];
int dist[103][103];  // 거리를 저장할 배열

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int n, m;

int main() {
  ios::sync_with_stdio(0), cin.tie(0);

  // 입력 받기
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> board[i];
  }

  for (int i = 0; i < n; i++) {
    fill(dist[i], dist[i] + m, -1);
  }

  // 보드 순회
  queue<pair<int, int>> Q;
  Q.push({0, 0});
  dist[0][0] = 0;  // 거리를 0으로 초기화

  while (!Q.empty()) {
    // 상하좌우 순회
    pair<int, int> cur = Q.front();
    Q.pop();
    for (int dir = 0; dir < 4; dir++) {
      int nx = dx[dir] + cur.first;
      int ny = dy[dir] + cur.second;

      if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
        continue;
      }
      if (dist[nx][ny] >= 0 || board[nx][ny] != '1') {
        continue;
      }

      dist[nx][ny] = dist[cur.first][cur.second] + 1;
      Q.push({nx, ny});
    }
  }

  // 문제의 특성상 거리 + 1이 정답
  cout << dist[n - 1][m - 1] + 1;
  return 0;
}