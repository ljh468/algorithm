#include <iostream>
#include <queue>
using namespace std;

string miro[1002];
int dist1[1002][1002];  // 불의 전파시간
int dist2[1002][1002];  // 지훈이의 이동시간
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};
int r, c;

/**
 * 불에 대한 BFS, 지훈이에 대한 BFS를 모두 돌려야함
 *
 */
int main() {
  ios::sync_with_stdio(0), cin.tie(0);

  cin >> r >> c;
  // 전파, 이동시간 기록 배열은 -1로 초기화
  for (int i = 0; i < r; i++) {
    fill(dist1[i], dist1[i] + c, -1);
    fill(dist2[i], dist2[i] + c, -1);
  }
  // 입력 받음
  for (int i = 0; i < r; i++) {
    cin >> miro[i];
  }

  queue<pair<int, int>> Q1;
  queue<pair<int, int>> Q2;
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      // 먼저 불이난 곳 큐에 넣어줌, 거리는 0으로 설정
      if (miro[i][j] == 'F') {
        Q1.push({i, j});
        dist1[i][j] = 0;
      }

      // 지훈이 위치 큐에 넣어줌, 거리는 0으로 초기화
      if (miro[i][j] == 'J') {
        Q2.push({i, j});
        dist2[i][j] = 0;
      }
    }
  }

  // 불에 대한 BFS
  while (!Q1.empty()) {
    pair<int, int> cur = Q1.front();
    Q1.pop();
    for (int dir = 0; dir < 4; dir++) {
      int nx = cur.first + dx[dir];
      int ny = cur.second + dy[dir];
      // 범위 밖이면 넘어감
      if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
      // 이미 전파된 곳이거나, 벽이면 넘어감
      if (dist1[nx][ny] >= 0 || miro[nx][ny] == '#') continue;
      // 이동할 수 있는 곳 거리 계산
      dist1[nx][ny] = dist1[cur.first][cur.second] + 1;
      Q1.push({nx, ny});
    }
  }

  // 지훈이에 대한 BFS
  while (!Q2.empty()) {
    pair<int, int> cur = Q2.front();
    Q2.pop();
    for (int dir = 0; dir < 4; dir++) {
      int nx = cur.first + dx[dir];
      int ny = cur.second + dy[dir];
      
      // 범위를 벗어났다는 것은 탈출에 성공했다는 의미. 큐에 거리 순으로 들어가므로 최초에 탈출한 시간을 출력하면 됨.
      if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
        cout << dist2[cur.first][cur.second] + 1; 
        return 0;
      }
      // 이미 기록된 곳이거나, 벽이면 넘어감
      if (dist2[nx][ny] >= 0 || miro[nx][ny] == '#') continue;
      
      // 불의 전파 시간을 조건에 추가
      // 불이 전파된 곳중에 지훈이가 이동한 시간보다 불이 전파된 시간이 작으면 넘어감
      if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.first][cur.second] + 1) continue;
      
      // 이동할 수 있는 곳 거리계산
      dist2[nx][ny] = dist2[cur.first][cur.second] + 1;
      Q2.push({nx, ny});
    }
  }
  
  // 탈출 실패
  cout << "IMPOSSIBLE";
  return 0;
}