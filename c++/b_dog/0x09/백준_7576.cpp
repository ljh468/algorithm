#include <iostream>
#include <queue>
using namespace std;

int board[1005][1005];
int dist[1005][1005];
int n, m;
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int main(void) {
  ios::sync_with_stdio(0), cin.tie(0);

  // 처음부터 1인 모든 위치를 큐에 넣고 시작
  // 이는 BFS 탐색이 여러 시작점에서 동시에 진행될 수 있도록 하며, 여러 개의
  // 출발점이 있을 경우를 처리할 수 있음
  cin >> m >> n;
  queue<pair<int, int> > Q;
  
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> board[i][j];
      // 시작점이 여러개인 경우 미리 큐에 넣어둠
      if (board[i][j] == 1) Q.push({i, j});
      // 익지 않은 토마토는 방문을 -1로 초기화
      if (board[i][j] == 0) dist[i][j] = -1;
    }
  }
  
  while (!Q.empty()) {
    pair<int, int> cur = Q.front();
    Q.pop();
    for (int dir = 0; dir < 4; dir++) {
      int nx = cur.first + dx[dir];
      int ny = cur.second + dy[dir];
      // 범위밖이면 넘어감
      if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
      // 이미 방문했다면 넘어감
      if (dist[nx][ny] >= 0) continue;
      // cnt 증가
      dist[nx][ny] = dist[cur.first][cur.second] + 1;
      Q.push({nx, ny});
    }
  }
  
  // 모든 배열 순회해서, 익는데 가장 오래 걸리는 시간을 리턴
  int ans = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (dist[i][j] == -1) {
        cout << -1;
        return 0;
      }
      ans = max(ans, dist[i][j]);
    }
  }
  cout << ans;
}